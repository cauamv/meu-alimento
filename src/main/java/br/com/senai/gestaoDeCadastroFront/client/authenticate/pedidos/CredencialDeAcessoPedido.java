package br.com.senai.gestaoDeCadastroFront.client.authenticate.pedidos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CredencialDeAcessoPedido {

	@Email(message = "O login deve seguir o padrão example@example.example")
	@NotBlank(message = "O login é obrigatório")
	private String login;
	
	@NotBlank(message = "A senha é obrigatório")
	private String senha;
}
