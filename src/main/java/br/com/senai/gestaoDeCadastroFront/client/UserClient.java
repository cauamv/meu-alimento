package br.com.senai.gestaoDeCadastroFront.client;

import java.net.URI;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.google.common.base.Preconditions;

import br.com.senai.gestaoDeCadastroFront.dto.UsuarioDto;
import lombok.Setter;

@Component
public class UserClient {

	private AplicadorDeToken aplicador = new AplicadorDeToken();
	
	private RestTemplate httpClient = new RestTemplate();
	
	@Setter
	private String token;
	
	public UsuarioDto inserir(UsuarioDto novoUsuario) {
		
		Preconditions.checkNotNull(novoUsuario, "O usuário é obrigatório. ");
		
		HttpEntity<UsuarioDto> request = new HttpEntity<UsuarioDto>(novoUsuario);

		URI location = httpClient.postForLocation("http://localhost:9090/usuarios", request);		
		
		request = new HttpEntity<UsuarioDto>(aplicador.aplicar(token));		
		
		ResponseEntity<UsuarioDto> usuarioSalvo = httpClient.exchange("http://localhost:9090" + location, HttpMethod.GET, request, UsuarioDto.class);
		
		return usuarioSalvo.getBody();
	}
	
}
