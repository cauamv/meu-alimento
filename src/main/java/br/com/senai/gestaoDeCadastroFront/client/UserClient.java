package br.com.senai.gestaoDeCadastroFront.client;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.common.base.Preconditions;

import br.com.senai.gestaoDeCadastroFront.client.authenticate.AutenticadorClient;
import br.com.senai.gestaoDeCadastroFront.dto.CredencialDeAcesso;
import br.com.senai.gestaoDeCadastroFront.dto.UsuarioDto;

@Component
public class UserClient {

	private AplicadorDeToken aplicador = new AplicadorDeToken();
	
	private RestTemplate httpClient = new RestTemplate();
	
	private AutenticadorClient autenticadorClient = new AutenticadorClient();
	
	
	public UsuarioDto inserir(UsuarioDto novoUsuario) {
		
		Preconditions.checkNotNull(novoUsuario, "O usuário é obrigatório. ");
		
		HttpEntity<UsuarioDto> request = new HttpEntity<UsuarioDto>(novoUsuario);

		URI location = httpClient.postForLocation("http://localhost:9090/usuarios", request);
		
		CredencialDeAcesso credencial = new CredencialDeAcesso();
		credencial.setEmail(novoUsuario.getEmail());
		credencial.setSenha(novoUsuario.getSenha());
		
		String token = autenticadorClient.getTokenPela(credencial).getValor();
		request = new HttpEntity<UsuarioDto>(aplicador.aplicar(token));		
		
		ResponseEntity<UsuarioDto> usuarioSalvo = httpClient.exchange("http://localhost:9090" 
				+ location, 
				HttpMethod.GET, 
				request, 
				UsuarioDto.class
		);
		
		return usuarioSalvo.getBody();
	}
	
}
