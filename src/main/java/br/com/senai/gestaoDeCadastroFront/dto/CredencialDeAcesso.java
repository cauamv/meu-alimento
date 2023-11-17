package br.com.senai.gestaoDeCadastroFront.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CredencialDeAcesso {

	@Email(message = "O email deve seguir o padrão example@example.example")
	@NotBlank(message = "O email é obrigatório")
	private String email;
	
	@NotBlank(message = "A senha é obrigatório")
	private String senha;
}
