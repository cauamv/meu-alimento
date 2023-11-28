package br.com.senai.gestaoDeCadastroFront.dto.pedidos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Cupom {

	@JsonProperty("id_cupom")
	private Integer id;
	
	@JsonProperty("codigo")
	private String codigo;
	
	@JsonProperty("valor")
	private String valor;
	
}
