package br.com.senai.gestaoDeCadastroFront.client.pedidos;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.senai.gestaoDeCadastroFront.client.AplicadorDeToken;
import br.com.senai.gestaoDeCadastroFront.client.authenticate.pedidos.AutenticadorPedidosClient;
import br.com.senai.gestaoDeCadastroFront.dto.Paginacao;
import br.com.senai.gestaoDeCadastroFront.dto.enums.Status;
import br.com.senai.gestaoDeCadastroFront.dto.pedidos.Pedido;

@Component
public class PedidosClient {

	private AplicadorDeToken aplicadorDeToken = new AplicadorDeToken();

	private RestTemplate httpClient = new RestTemplate();

	private AutenticadorPedidosClient autenticadorClient = new AutenticadorPedidosClient();

	private String URL = "http://localhost:8080";

	private final String GET_ENDPOINT = "/pedidos"; 

	public Paginacao<Pedido> listarPor(Integer idRestaurante, Integer pagina, Status status) {

		StringBuilder queryParams = new StringBuilder();
		queryParams.append("?status=").append(status.toString());
		queryParams.append("&pagina=").append(pagina);
		queryParams.append("&id-restaurante=").append(idRestaurante);

		String token = autenticadorClient.getToken().getValor();

		HttpEntity<Paginacao<Pedido>> request = new HttpEntity<Paginacao<Pedido>>(
				aplicadorDeToken.aplicar(token));

		ResponseEntity<Paginacao<Pedido>> pedidosEncontrados = httpClient.exchange(
				URL + GET_ENDPOINT + queryParams, 
				HttpMethod.GET, 
				request, 
				new ParameterizedTypeReference<Paginacao<Pedido>>(){});
		
		ResponseEntity<String> response = httpClient.exchange(
				URL + GET_ENDPOINT + queryParams, 
				HttpMethod.GET, 
				request, 
				String.class);
		
		System.out.println(response);
		
		return pedidosEncontrados.getBody();

	}

}
