package br.com.senai.gestaoDeCadastroFront.client.pedidos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

	@Autowired
	private AplicadorDeToken aplicadorDeToken;

	@Autowired
	private RestTemplate httpClient;

	@Autowired
	private AutenticadorPedidosClient autenticadorClient;	

	@Value("${pedidos.url}")
	private String URL;

	private final String ENDPOINT = "/pedidos";
	
	public Paginacao<Pedido> listarPor(Integer idRestaurante, Integer pagina, Status status) {

		StringBuilder queryParams = new StringBuilder();
		queryParams.append("?status=").append(status.toString());
		queryParams.append("&pagina=").append(pagina);
		queryParams.append("&id-restaurante=").append(idRestaurante);
		queryParams.append("&status=ACEITO_PELO_RESTAURANTE");

		String token = autenticadorClient.getToken().getValor();

		HttpEntity<Paginacao<Pedido>> request = new HttpEntity<Paginacao<Pedido>>(
				aplicadorDeToken.aplicar(token));

		ResponseEntity<Paginacao<Pedido>> pedidosEncontrados = httpClient.exchange(
				URL + ENDPOINT + queryParams, 
				HttpMethod.GET, 
				request, 
				new ParameterizedTypeReference<Paginacao<Pedido>>(){});
		
		return pedidosEncontrados.getBody();

	}
	
	public void atualizarPor(Integer idDoPedido, Status status) {
		HttpEntity<Pedido> request = new HttpEntity<Pedido>(aplicadorDeToken.aplicar(autenticadorClient.getToken().getValor()));
		this.httpClient.patchForObject(URL + ENDPOINT + "/id/" + idDoPedido.toString() + "/status/" + status, request, Void.class);
		
	}

}
