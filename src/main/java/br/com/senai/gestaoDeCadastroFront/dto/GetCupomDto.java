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
public class GetCupomDto {

	@JsonProperty("id")
	@NotNull(message = "O id é obrigatório. ")
	private Integer id;
	
	@JsonProperty("percentualDeDesconto")
	@NotNull(message = "O valor é obrigatório. ")
	private Double percentualDeDesconto;
	
	@JsonProperty("validade")
	@NotNull(message = "A validade é obrigatória. ")
	private LocalDate validade;
	
	@JsonProperty("codigo")
	@NotBlank(message = "O código é obrigatório. ")
	private String codigo;
	
}
