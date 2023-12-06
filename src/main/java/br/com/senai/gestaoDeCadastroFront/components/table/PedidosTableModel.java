package br.com.senai.gestaoDeCadastroFront.components.table;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.senai.gestaoDeCadastroFront.dto.pedidos.Pedido;

public class PedidosTableModel extends AbstractTableModel {

private static final long serialVersionUID = 1L;
	
	private final int QTDE_COLUNAS = 4;
	
	private List<Pedido> pedidos;

	public PedidosTableModel() {
		this.pedidos = new ArrayList<>();
	}
	
	public PedidosTableModel(List<Pedido> pedidos) {
		this();
		if (pedidos != null && !pedidos.isEmpty()) {		
			this.pedidos = pedidos;
		}
	}

	@Override
	public int getRowCount() {	
		return pedidos.size();
	}
	
	@Override
	public int getColumnCount() {
		return QTDE_COLUNAS;
	}
	
	@Override
	public String getColumnName(int column) {
		if (column == 0) {
			return "Numero do pedido";
		} else if (column == 1) {
			return "Cliente";
		} else if (column == 2) {
			return "Endereço";
		} else if (column == 3) {
			return "Status";
		}
		throw new IllegalArgumentException("Indíce inválido");
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex == 0) {
			return pedidos.get(rowIndex).getIdPedido();
		} else if (columnIndex == 1) {
			return pedidos.get(rowIndex).getCliente().getNome();
		} else if (columnIndex == 2) {
			return pedidos.get(rowIndex).getEndereco().getNumero();
		} else if (columnIndex == 3) {
			return pedidos.get(rowIndex).getStatus();
		}
		throw new IllegalArgumentException("Índice inválido");
	}
	
	public Pedido getPor(int rowIndex) {
		return pedidos.get(rowIndex);
	}	

}