package br.com.senai.gestaoDeCadastroFront.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {
	
	@JsonProperty("id")
	private Integer id;
	
	@JsonProperty("email")
	@NotBlank(message = "O email é obrigatório")
	private String email;
	
	@JsonProperty("senha")
	@NotBlank(message = "A senha é obrigatória")
	private String senha;
	
	@JsonProperty("role")	
	@NotBlank(message = "A papel é obrigatório")
	private String role;
	
}
