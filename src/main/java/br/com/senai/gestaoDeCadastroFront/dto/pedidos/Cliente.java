package br.com.senai.gestaoDeCadastroFront.dto.pedidos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Cliente {

	@JsonProperty("id_cliente")
	private Integer id;
	
	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("email")
	private String email;
}
