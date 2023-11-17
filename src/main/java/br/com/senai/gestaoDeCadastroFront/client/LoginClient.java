package br.com.senai.gestaoDeCadastroFront.client;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.senai.gestaoDeCadastroFront.dto.CredencialDeAcesso;

@Component
public class LoginClient {

	@Autowired
	private RestTemplate httpClient;
	
	public String autenticar(CredencialDeAcesso credencialDeAcesso) {
		
		ResponseEntity<String> response = httpClient.postForEntity("http://localhost:9090/auth", credencialDeAcesso, String.class);
		JSONObject bodyResponse = new JSONObject(response.getBody());
		return bodyResponse.getString("token");
		
	}
	
}
