package br.com.senai.gestaoDeCadastroFront.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NovoClienteDto {

	@JsonProperty("nome")
	@NotBlank(message = "O nome é obrigatório. ")
	private String nome;
	
	@JsonProperty("sexo")
	@NotBlank(message = "O sexo é obrigatório. ")
	private String sexo;
	
	@JsonProperty("dataDeNascimento")
	@NotNull(message = "A data de nascimento é obrigatória. ")
	private LocalDate dataDeNascimento;
	
	@JsonProperty("usuario")
	@NotNull(message = "O usuário é obrigatório. ")
	private UsuarioDto usuario;
}
