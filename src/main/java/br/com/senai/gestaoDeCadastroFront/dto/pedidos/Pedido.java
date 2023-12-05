package br.com.senai.gestaoDeCadastroFront.dto.pedidos;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.senai.gestaoDeCadastroFront.dto.enums.Status;
import lombok.Data;

@Data
public class Pedido {

	@JsonProperty("opcoes")
	private List<Opcoes> opcoes;
	
	@JsonProperty("endereco")
	private Endereco endereco;
	
	@JsonProperty("restaurante")
	private Restaurante restaurante;
	
	@JsonProperty("cliente")
	private Cliente cliente;
	
	@JsonProperty("cupom")
	private Cupom cupom;
	
	@JsonProperty("desconto")
	private BigDecimal desconto;
	
	@JsonProperty("valor_do_frete")
	private BigDecimal valorDoFrete;
	
	@JsonProperty("valor_dos_itens")
	private BigDecimal valorDosItens;
	
	@JsonProperty("tipo_entrega")
	private String tipoDeEntrega;
	
	@JsonProperty("data_pedido")
	private String dataPedido;
	
	@JsonProperty("pagamento")
	private String pagamento;
	
	@JsonProperty("id_pedido")
	private Integer idPedido;
	
	@JsonProperty("status")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@JsonProperty("valor_total")
	private BigDecimal valorTotal;
}
