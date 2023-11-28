package br.com.senai.gestaoDeCadastroFront.dto.pedidos;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Opcoes {
	
	@JsonProperty("promocao")
	private String promocao;
	
	@JsonProperty("qtde_itens")
	private Integer qtdeItens;
	
	@JsonProperty("subtotal")
	private Integer subtotal;
	
	@JsonProperty("valor")
	private BigDecimal valor;
	
	@JsonProperty("nome")
	private String nome;
}
