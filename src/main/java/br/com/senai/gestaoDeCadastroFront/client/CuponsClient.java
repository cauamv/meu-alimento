package br.com.senai.gestaoDeCadastroFront.client;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.common.base.Preconditions;

import br.com.senai.gestaoDeCadastroFront.client.authenticate.server.AutenticadorClient;
import br.com.senai.gestaoDeCadastroFront.client.authenticate.server.CredencialDeAcesso;
import br.com.senai.gestaoDeCadastroFront.dto.Cupom;
import br.com.senai.gestaoDeCadastroFront.dto.GetCupomDto;
import br.com.senai.gestaoDeCadastroFront.dto.NovoCupomDto;
import br.com.senai.gestaoDeCadastroFront.dto.Paginacao;
import br.com.senai.gestaoDeCadastroFront.dto.enums.StatusDoCupom;

@Component
public class CuponsClient {

	@Autowired
	private AplicadorDeToken aplicadorDeToken;

	@Autowired
	private RestTemplate httpClient;

	@Autowired
	private AutenticadorClient autenticadorClient;

	@Value("${base.url}")
	private String URL;

	private String ENDPOINT = "/cupons";
	
	public Paginacao<Cupom> listarTodos(Integer pagina, CredencialDeAcesso credencialDeAcesso) {
		String token = autenticadorClient.getTokenPela(credencialDeAcesso).getValor();
		HttpHeaders headers = aplicadorDeToken.aplicar(token);

		ResponseEntity<Paginacao<Cupom>> cuponsEncontrados = httpClient.exchange(URL + ENDPOINT,
				HttpMethod.GET, new HttpEntity<>(headers), new ParameterizedTypeReference<Paginacao<Cupom>>() {
				});
		return cuponsEncontrados.getBody();

	}

	public GetCupomDto inserir(NovoCupomDto cupomCadastroDto, CredencialDeAcesso credencialDeAcesso) {

		Preconditions.checkNotNull(cupomCadastroDto, "O cupom é obrigatório.");
		
		CredencialDeAcesso credencial = new CredencialDeAcesso();
		credencial.setEmail(credencialDeAcesso.getEmail());
		credencial.setSenha(credencialDeAcesso.getSenha());
		
		String token = autenticadorClient.getTokenPela(credencial).getValor();

		HttpHeaders headers = aplicadorDeToken.aplicar(token);
		
		HttpEntity<NovoCupomDto> request = new HttpEntity<NovoCupomDto>(cupomCadastroDto, headers);		

		URI location = httpClient.postForLocation(URL + ENDPOINT, request);
		
		ResponseEntity<GetCupomDto> cupomSalvo = httpClient.exchange(
				URL + location,
	            HttpMethod.GET,
				new HttpEntity<>(headers),
				GetCupomDto.class
		);
		
		return cupomSalvo.getBody();
	}
	
	public void atualizarPor(Integer idDoCupom, StatusDoCupom status, CredencialDeAcesso credencialDeAcesso) {
		HttpEntity<Cupom> request = new HttpEntity<Cupom>(aplicadorDeToken.aplicar(autenticadorClient.getTokenPela(credencialDeAcesso).getValor()));
		this.httpClient.patchForObject(URL + ENDPOINT + "/id/" + idDoCupom.toString() + "/status/" + status, request, Void.class);
	}
	
	public Cupom alterar(Cupom cupom, CredencialDeAcesso credencialDeAcesso) {
		HttpHeaders headers = aplicadorDeToken.aplicar(autenticadorClient.getTokenPela(credencialDeAcesso).getValor());
		
		HttpEntity<Cupom> request = new HttpEntity<Cupom>(cupom, headers);	
		
		ResponseEntity<Cupom> cupomAtualizado = httpClient.exchange(
				URL + ENDPOINT, HttpMethod.PUT, request, Cupom.class);
		return cupomAtualizado.getBody();
	}

}