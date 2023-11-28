package br.com.senai.gestaoDeCadastroFront.dto.pedidos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Endereco {
	
	@JsonProperty("estado")
	private String estado;
	
	@JsonProperty("cidade")
	private String cidade;
	
	@JsonProperty("complemento")
	private String complemento;
	
	@JsonProperty("numero")
	private String numero;
	
	@JsonProperty("bairro")
	private String bairro;
	
	@JsonProperty("id_endereco")
	private Integer id;
	
	@JsonProperty("CEP")
	private String cep;

}
