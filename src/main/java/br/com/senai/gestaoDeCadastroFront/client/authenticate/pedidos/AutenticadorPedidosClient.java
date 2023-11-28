package br.com.senai.gestaoDeCadastroFront.client.authenticate.pedidos;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.senai.gestaoDeCadastroFront.client.authenticate.Token;
import br.com.senai.gestaoDeCadastroFront.dto.TokenDto;

public class AutenticadorPedidosClient {
	
	private String URL = "http://localhost:8080";

	private String login = "integracao@pedidos.com";
	
	private String senha = "querocafe";

	private final String ENDPOINT = "/auth";

	private RestTemplate httpClient = new RestTemplate();

	private Token token;

	public Token getToken() {
		if (token != null && !token.isExpirado()) {
			return token;
		} else {
			return autenticar();
		}
	}

	private Token autenticar() {
		CredencialDeAcessoPedido credencial = new CredencialDeAcessoPedido(login, senha);
		
		HttpEntity<CredencialDeAcessoPedido> request = new HttpEntity<CredencialDeAcessoPedido>(credencial);

		ResponseEntity<TokenDto> tokenGerado = httpClient.exchange(URL + ENDPOINT, HttpMethod.POST, request,
				TokenDto.class);

		token = new Token(tokenGerado.getBody().getToken());
		return token;
	}
}
