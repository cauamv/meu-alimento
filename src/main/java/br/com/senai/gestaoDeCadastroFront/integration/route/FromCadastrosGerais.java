package br.com.senai.gestaoDeCadastroFront.integration.route;

import java.io.Serializable;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.http.HttpMethods;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class FromCadastrosGerais extends RouteBuilder implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String url = "http://localhost:9090";
	
	@Override
	public void configure() throws Exception {
		from("direct:cadastros")
			.setHeader(Exchange.HTTP_METHOD, constant(HttpMethods.POST))
			.setHeader(Exchange.CONTENT_TYPE, constant("application/json;charset=UTF-8"))
			.process(new Processor() {
				@Override
				public void process(Exchange exchange) throws Exception {
					String responseJson = exchange.getIn().getBody(String.class);
					JSONObject jsonObject = new JSONObject(responseJson);
					Integer idEndereco = jsonObject.getInt("idEndereco");
					exchange.setProperty("idEndereco", idEndereco);

					JSONObject requestBody = new JSONObject();
					requestBody.put("email", "kauanmello123@gmail.com");
					requestBody.put("senha", "12345678");
					exchange.getMessage().setBody(requestBody.toString());
				}
			}).to(url + "/auth").process(new Processor() {
				@Override
				public void process(Exchange exchange) throws Exception {
					String responseJson = exchange.getMessage().getBody(String.class);
					JSONObject jsonObject = new JSONObject(responseJson);
					String token = jsonObject.getString("token");
					exchange.setProperty("token", token);
				}
			}).setHeader(Exchange.HTTP_METHOD, constant(HttpMethods.GET))
			.setHeader(Exchange.CONTENT_TYPE, constant("application/json;charset=UTF-8"))
			.setHeader("Authorization", simple("Bearer ${exchangeProperty.token}"))
			.toD(url + "/enderecos/id/${exchangeProperty.idEndereco}")
			.process(new Processor() {

				@Override
				public void process(Exchange exchange) throws Exception {
					String responseJson = exchange.getIn().getBody(String.class);
					JSONObject jsonObject = new JSONObject(responseJson);
					exchange.getMessage().setBody(jsonObject.toString());
				}
			})
			.end();
	}
}
	
