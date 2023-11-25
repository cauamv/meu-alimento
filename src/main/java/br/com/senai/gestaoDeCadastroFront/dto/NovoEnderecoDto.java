package br.com.senai.gestaoDeCadastroFront.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NovoEnderecoDto {

	@JsonProperty("nome")
	@NotBlank(message = "O nome é obrigatório. ")
	private String nome;
	
	@JsonProperty("cep")
	@NotBlank(message = "O cep é obrigatório. ")
	private String cep;
	
	@JsonProperty("rua")
	@NotBlank(message = "A rua é obrigatória. ")
	private String rua;
	
	@JsonProperty("bairro")
	@NotBlank(message = "O bairro é obrigatório. ")
	private String bairro;
	
	@JsonProperty("cidade")
	@NotBlank(message = "A cidade é obrigatória. ")
	private String cidade;
	
	@JsonProperty("estado")
	@NotBlank(message = "O estado é obrigatório. ")
	private String estado;
	
	@JsonProperty("numeroDaCasa")
	@NotBlank(message = "O numero da dasa é obrigatório. ")
	private String numeroDaCasa;
	
	@JsonProperty("complemento")
	private String complemento;
	
	@JsonProperty("cliente")
	@NotNull(message = "O cliente é obrigatório. ")
	private ClienteDto clienteDto;
	
}
