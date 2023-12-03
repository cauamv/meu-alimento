package br.com.senai.gestaoDeCadastroFront.client;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.common.base.Preconditions;

import br.com.senai.gestaoDeCadastroFront.client.authenticate.server.AutenticadorClient;
import br.com.senai.gestaoDeCadastroFront.client.authenticate.server.CredencialDeAcesso;
import br.com.senai.gestaoDeCadastroFront.dto.UsuarioDto;

@Component
public class UserClient {

	@Autowired
	private AplicadorDeToken aplicador;
	
	private RestTemplate httpClient = new RestTemplate();
	
	@Autowired
	private AutenticadorClient autenticadorClient;
	
	@Value("${base.url}")
	private String URL;
	
	private String POST_ENDPOINT = "/usuarios";
	
	public UsuarioDto inserir(UsuarioDto novoUsuario) {
		
		Preconditions.checkNotNull(novoUsuario, "O usuário é obrigatório. ");
		
		HttpEntity<UsuarioDto> request = new HttpEntity<UsuarioDto>(novoUsuario);
		
		URI location = httpClient.postForLocation(URL + POST_ENDPOINT, request);
		
		CredencialDeAcesso credencial = new CredencialDeAcesso();
		credencial.setEmail(novoUsuario.getEmail());
		credencial.setSenha(novoUsuario.getSenha());
		
		String token = autenticadorClient.getTokenPela(credencial).getValor();
		
		request = new HttpEntity<UsuarioDto>(aplicador.aplicar(token));		
		
		ResponseEntity<UsuarioDto> usuarioSalvo = httpClient.exchange(
				URL + location, 
				HttpMethod.GET, 
				request, 
				UsuarioDto.class
		);
		return usuarioSalvo.getBody();
	}
	
}
