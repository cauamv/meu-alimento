package br.com.senai.gestaoDeCadastroFront.client;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.senai.gestaoDeCadastroFront.client.authenticate.server.CredencialDeAcesso;

@Component
public class LoginClient {

	@Autowired
	private RestTemplate httpClient;
	
	@Value("${base.url}")
	private String URL;
	
	private String ENDPOINT = "/auth";
	
	public String autenticar(CredencialDeAcesso credencialDeAcesso) {
		
		ResponseEntity<String> response = httpClient.postForEntity(
				URL + ENDPOINT, 
				credencialDeAcesso, 
				String.class);
		
		JSONObject bodyResponse = new JSONObject(response.getBody());
		
		return bodyResponse.getString("token");
		
	}
	
}
