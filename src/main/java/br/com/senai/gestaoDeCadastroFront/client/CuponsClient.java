package br.com.senai.gestaoDeCadastroFront.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.senai.gestaoDeCadastroFront.client.authenticate.server.AutenticadorClient;
import br.com.senai.gestaoDeCadastroFront.client.authenticate.server.CredencialDeAcesso;
import br.com.senai.gestaoDeCadastroFront.dto.Cupom;
import br.com.senai.gestaoDeCadastroFront.dto.Paginacao;

@Component
public class CuponsClient {

	private AplicadorDeToken aplicadorDeToken = new AplicadorDeToken();

	private RestTemplate httpClient = new RestTemplate();

	private AutenticadorClient autenticadorClient = new AutenticadorClient();

	@Value("${base.url}")
	private String URL;
	
	public Paginacao<Cupom> listarTodos(Integer pagina, CredencialDeAcesso credencialDeAcesso) {
		String token = autenticadorClient.getTokenPela(credencialDeAcesso).getValor();

		HttpHeaders headers = aplicadorDeToken.aplicar(token);
		
		ResponseEntity<Paginacao<Cupom>> cuponsEncontrados = httpClient.exchange(
				"http://localhost:3001/cupons", 
				HttpMethod.GET, 
				new HttpEntity<>(headers), 
				new ParameterizedTypeReference<Paginacao<Cupom>>(){});
		
		return cuponsEncontrados.getBody();

	}



}