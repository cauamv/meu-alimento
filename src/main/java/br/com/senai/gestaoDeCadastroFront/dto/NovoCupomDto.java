package br.com.senai.gestaoDeCadastroFront.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.senai.gestaoDeCadastroFront.dto.enums.StatusDoCupom;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NovoCupomDto {

	@JsonProperty("percentualDeDesconto")
	@NotNull(message = "O valor é obrigatório. ")
	private Double percentualDeDesconto;
	
	@JsonProperty("validade")
	@NotNull(message = "A validade é obrigatória. ")
	private LocalDate validade;
	
	@JsonProperty("codigo")
	@NotBlank(message = "O código é obrigatório. ")
	private String codigo;
	
	@JsonProperty("status")
	@NotBlank(message = "O status é obrigatório. ")
	private StatusDoCupom status;
}
