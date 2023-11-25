package br.com.senai.gestaoDeCadastroFront.client.authenticate.server;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CredencialDeAcesso {

	@Email(message = "O email deve seguir o padrão example@example.example")
	@NotBlank(message = "O email é obrigatório")
	private String email;
	
	@NotBlank(message = "A senha é obrigatório")
	private String senha;
}
