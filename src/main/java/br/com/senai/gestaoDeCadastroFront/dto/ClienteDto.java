package br.com.senai.gestaoDeCadastroFront.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {

	@NotNull(message = "O id é obrigatório. ")
	private Integer id;
	
	@NotBlank(message = "O nome é obrigatório. ")
	private String nome;
	
	@NotBlank(message = "O sexo é obrigatório. ")
	private String sexo;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "A data de nascimento é obrigatória. ")
	private LocalDate dataDeNascimento;
	
	@NotNull(message = "O usuário é obrigatório. ")
	private UsuarioDto usuario;
	
}
