package br.com.senai.gestaoDeCadastroFront.client.pedidos;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
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

	private String URL = "http://localhost:3000";

	private final String ENDPOINT = "/pedidos";
	
	public Paginacao<Pedido> listarPor(Integer idRestaurante, Integer pagina, Status status) {

		StringBuilder queryParams = new StringBuilder();
		queryParams.append("?status=").append(status.toString());
		queryParams.append("&pagina=").append(pagina);
		queryParams.append("&id-restaurante=").append(idRestaurante);

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
		
		HttpHeaders headers = aplicadorDeToken.aplicar(autenticadorClient.getToken().getValor());
		
		this.httpClient.exchange(
				URL + ENDPOINT + "/id/" + idDoPedido.toString() + "/status/" + status.toString(),
				HttpMethod.PATCH, 
				new HttpEntity<>(headers),
				Void.class
		);
		
	}

}
