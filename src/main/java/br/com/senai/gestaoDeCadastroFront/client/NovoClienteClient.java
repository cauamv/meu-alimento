package br.com.senai.gestaoDeCadastroFront.client;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.common.base.Preconditions;

import br.com.senai.gestaoDeCadastroFront.client.authenticate.AutenticadorClient;
import br.com.senai.gestaoDeCadastroFront.dto.CadastroClienteDto;
import br.com.senai.gestaoDeCadastroFront.dto.CredencialDeAcesso;

//@Component
//public class NovoClienteClient {
//
//	private AplicadorDeToken aplicador = new AplicadorDeToken();
//	
//	private RestTemplate httpClient = new RestTemplate();
//	
//	private AutenticadorClient autenticadorClient = new AutenticadorClient();
//	
//	public CadastroClienteDto inserir(CadastroClienteDto novoCliente) {
//		
//		Preconditions.checkNotNull(novoCliente, "O usuário é obrigatório. ");
//		
//		HttpEntity<CadastroClienteDto> request = new HttpEntity<CadastroClienteDto>(novoCliente);
//
//	    URI location = httpClient.postForLocation("http://localhost:9090/usuarios", request);
//		
//	    CredencialDeAcesso credencial = new CredencialDeAcesso();
//		CadastroClienteDto cliente = new CadastroClienteDto();
//		cliente.setNome(novoCliente.getNome());
//		cliente.setCpf(novoCliente.getCpf());
//		cliente.setEmail(novoCliente.getEmail());
//		cliente.setSenha(novoCliente.getSenha());
//		cliente.setTel(novoCliente.getTel());
//		
//		credencial.setEmail(cliente.getEmail());
//		credencial.setSenha(cliente.getSenha());
//		
//		String token = autenticadorClient.getTokenPela(credencial).getValor();
//		request = new HttpEntity<CadastroClienteDto>(aplicador.aplicar(token));		
//		
//		ResponseEntity<CadastroClienteDto> clienteSalvo = httpClient.exchange("http://localhost:9090" 
//				+ location, 
//				HttpMethod.POST, 
//				request, 
//				CadastroClienteDto.class
//		);
//		
//		return clienteSalvo.getBody();
//	}
//	
//}
