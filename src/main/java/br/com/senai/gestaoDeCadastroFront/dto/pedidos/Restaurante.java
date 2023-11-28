package br.com.senai.gestaoDeCadastroFront.dto.pedidos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Restaurante {
	
	@JsonProperty("id_restaurante")
	private Integer id;
	
	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("cep")
	private String cep;
}
