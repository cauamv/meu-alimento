package br.com.senai.gestaoDeCadastroFront.client.authenticate.pedidos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.senai.gestaoDeCadastroFront.client.authenticate.Token;
import br.com.senai.gestaoDeCadastroFront.dto.TokenDto;

@Component
public class AutenticadorPedidosClient {
	
	private String URL = "http://localhost:3000";

	private String login = "integracao@pedidos.com";
	
	private String senha = "querocafe";

	private final String ENDPOINT = "/auth";
	
	@Autowired
	private RestTemplate httpClient;

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
