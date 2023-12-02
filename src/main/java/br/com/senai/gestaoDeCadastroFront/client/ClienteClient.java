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
import br.com.senai.gestaoDeCadastroFront.dto.ClienteDto;
import br.com.senai.gestaoDeCadastroFront.dto.NovoClienteDto;
import br.com.senai.gestaoDeCadastroFront.dto.UsuarioDto;

@Component
public class ClienteClient {

	private AplicadorDeToken aplicadorDeToken = new AplicadorDeToken();
	
	private RestTemplate httpClient = new RestTemplate();
	
	private AutenticadorClient autenticadorClient = new AutenticadorClient();
	
	@Value("${base.url}")
	private String URL;
	
	private String POST_ENDPOINT = "/clientes";
	
	private String GET_ENDPOINT = "/clientes/id/";
	
	@Autowired
	private UserClient userClient;
	
	public ClienteDto inserir(NovoClienteDto clienteCadastroDto) {
		
		Preconditions.checkNotNull(clienteCadastroDto, "O cliente é obrigatório.");
	    
		String email = clienteCadastroDto.getUsuario().getEmail();
	    String senha = clienteCadastroDto.getUsuario().getSenha();
	    
	    UsuarioDto usuarioDto = userClient.inserir(clienteCadastroDto.getUsuario());
	    
	    CredencialDeAcesso credencial = new CredencialDeAcesso();
	    credencial.setEmail(email);
	    credencial.setSenha(senha);
	    
	    clienteCadastroDto.getUsuario().setId(usuarioDto.getId());

	    String token = autenticadorClient.getTokenPela(credencial).getValor();

	    HttpHeaders headers = aplicadorDeToken.aplicar(token);

	    HttpEntity<NovoClienteDto> request = new HttpEntity<>(clienteCadastroDto, headers);
	    System.out.println(request);

	    URI location = httpClient.postForLocation(URL + POST_ENDPOINT, request);
	    
	    ResponseEntity<ClienteDto> clienteSalvo = httpClient.exchange(
	            URL + location,
	            HttpMethod.GET,
	            new HttpEntity<>(headers),
	            ClienteDto.class
	    );

	    return clienteSalvo.getBody();
	}

	
	public ClienteDto buscarClientePor(Integer id, CredencialDeAcesso credencialDeAcesso) {
		Preconditions.checkNotNull(id, "O id é obrigatório");
		
		String token = autenticadorClient.getTokenPela(credencialDeAcesso).getValor();
		
		HttpHeaders headers = aplicadorDeToken.aplicar(token);
	    
	    ResponseEntity<ClienteDto> clienteEncontrado = httpClient.exchange(
	    		URL + GET_ENDPOINT + id,
	            HttpMethod.GET,
	            new HttpEntity<>(headers),
	            ClienteDto.class
	    );

	    return clienteEncontrado.getBody();
	}
}
