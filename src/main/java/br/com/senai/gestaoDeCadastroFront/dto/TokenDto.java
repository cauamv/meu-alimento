package br.com.senai.gestaoDeCadastroFront.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TokenDto {
	
	@NotBlank(message = "O token é obrigatório. ")
	private String token;
	
	@NotNull(message = "O campo criado em é obrigatório. ")
	private LocalDateTime criadoEm;
}
