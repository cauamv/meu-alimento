package br.com.senai.gestaoDeCadastroFront.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonInclude(Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CadastroClienteDto {

	@NotBlank(message = "O nome do usuário é obrigatório")
	private String nome;
	
	@NotBlank(message = "O CPF do usuário é obrigatório")
	private String cpf;
	
	@Email
	@NotBlank(message = "O e-mail do usuário é obrigatório")
	private String email;
	
	@NotBlank(message = "O telefone do usuário é obrigatório")
	private String tel;
	
	@NotNull(message = "A senha do usuário é obrigatório")
	private String senha;
}
