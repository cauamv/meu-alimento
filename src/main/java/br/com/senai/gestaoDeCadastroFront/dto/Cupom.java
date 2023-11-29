package br.com.senai.gestaoDeCadastroFront.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cupom {

	@NotNull(message = "O id é obrigatório. ")
	private Integer id;
	
	@NotNull(message = "O valor é obrigatório. ")
	private Double valor;
	
	@NotNull(message = "A validade é obrigatória. ")
	private LocalDate validade;
	
	@NotBlank(message = "O código é obrigatório. ")
	private String codigo;
	
}
