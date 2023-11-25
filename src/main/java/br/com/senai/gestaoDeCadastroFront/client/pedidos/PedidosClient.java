package br.com.senai.gestaoDeCadastroFront.client.pedidos;

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
import br.com.senai.gestaoDeCadastroFront.dto.PedidoDto;
import br.com.senai.gestaoDeCadastroFront.dto.enums.Status;

@Component
public class PedidosClient {

	private AplicadorDeToken aplicadorDeToken = new AplicadorDeToken();

	private RestTemplate httpClient = new RestTemplate();

	private AutenticadorPedidosClient autenticadorClient = new AutenticadorPedidosClient();

	@Value("${pedidos.url}")
	private String URL;

	private final String GET_ENDPOINT = "/pedidos";

	public Paginacao<PedidoDto> listarPor(Integer idRestaurante, Integer pagina, Status status) {

		StringBuilder queryParams = new StringBuilder();
		queryParams.append("?status=").append(status);
		queryParams.append("&pagina=").append(pagina);
		queryParams.append("&id-restaurante=").append(idRestaurante);

		String token = autenticadorClient.getToken().getValor();

		HttpEntity<Paginacao<PedidoDto>> request = new HttpEntity<Paginacao<PedidoDto>>(
				aplicadorDeToken.aplicar(token));

		ResponseEntity<Paginacao<PedidoDto>> pedidosEncontrados = httpClient.exchange(URL + GET_ENDPOINT + queryParams,
				HttpMethod.GET, request, new ParameterizedTypeReference<Paginacao<PedidoDto>>() {
				});

		return pedidosEncontrados.getBody();

	}

}
