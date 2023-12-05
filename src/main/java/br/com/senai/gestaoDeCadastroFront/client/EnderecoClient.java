package br.com.senai.gestaoDeCadastroFront.client;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.common.base.Preconditions;

import br.com.senai.gestaoDeCadastroFront.client.authenticate.server.AutenticadorClient;
import br.com.senai.gestaoDeCadastroFront.client.authenticate.server.CredencialDeAcesso;
import br.com.senai.gestaoDeCadastroFront.dto.NovoEnderecoDto;

@Component
public class EnderecoClient {
	
	@Value("${base.url}")
	private String URL;
	
	private String POST_ENDPOINT = "/enderecos";
	
	@Autowired
	private RestTemplate httpClient;
	
	@Autowired
	private AutenticadorClient autenticadorClient;
	
	@Autowired
	private AplicadorDeToken aplicadorDeToken;
	
	public NovoEnderecoDto inserir(NovoEnderecoDto novoEnderecoDto, CredencialDeAcesso credencialDeAcesso) {
		Preconditions.checkNotNull(novoEnderecoDto, "O endereço é obrigatório. ");
		

		String token = autenticadorClient.getTokenPela(credencialDeAcesso).getValor();
		HttpHeaders headers = aplicadorDeToken.aplicar(token);
		
		HttpEntity<NovoEnderecoDto> request = new HttpEntity<>(novoEnderecoDto, headers);
		
	    URI location = httpClient.postForLocation(URL + POST_ENDPOINT, request);
	    
	    ResponseEntity<NovoEnderecoDto> enderecoSalvo = httpClient.exchange(
	            URL + location,
	            HttpMethod.GET,
	            new HttpEntity<>(headers),
	            NovoEnderecoDto.class
	    );

			
		return enderecoSalvo.getBody();
	}
}
