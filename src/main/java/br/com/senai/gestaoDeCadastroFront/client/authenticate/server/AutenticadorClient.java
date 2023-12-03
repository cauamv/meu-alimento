package br.com.senai.gestaoDeCadastroFront.client.authenticate.server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.common.base.Preconditions;

import br.com.senai.gestaoDeCadastroFront.client.authenticate.Token;
import br.com.senai.gestaoDeCadastroFront.dto.TokenDto;

@Component
public class AutenticadorClient {
	
	@Value("${base.url}")
	private String URL;
	
	private RestTemplate httpClient = new RestTemplate();
	
	private Token token;
	
	public Token getTokenPela(CredencialDeAcesso credencialDeAcesso) {
		if (token != null && !token.isExpirado()) {
			return token;
		} else {
			return autenticar(credencialDeAcesso);
		}
	}
	
	private Token autenticar(CredencialDeAcesso credencial) {
		Preconditions.checkNotNull(credencial, "As credenciais de acesso são obrigatórias. ");
		HttpEntity<CredencialDeAcesso> request = new HttpEntity<CredencialDeAcesso>(credencial);
		
		ResponseEntity<TokenDto> tokenGerado = httpClient.exchange(
				"http://localhost:3001/auth",
				HttpMethod.POST,
				request,
				TokenDto.class
		);
		
		token = new Token(tokenGerado.getBody().getToken());
		return token;
	}
	
}
