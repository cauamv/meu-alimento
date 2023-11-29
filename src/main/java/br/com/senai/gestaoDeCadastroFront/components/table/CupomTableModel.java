package br.com.senai.gestaoDeCadastroFront.components.table;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.senai.gestaoDeCadastroFront.dto.Cupom;

public class CupomTableModel extends AbstractTableModel {

private static final long serialVersionUID = 1L;
	
	private final int QTDE_COLUNAS = 4;
	
	private List<Cupom> cupons;

	public CupomTableModel() {
		this.cupons = new ArrayList<>();
	}
	
	public CupomTableModel(List<Cupom> cupons) {
		this();
		if (cupons != null && !cupons.isEmpty()) {		
			this.cupons = cupons;
		}
	}

	@Override
	public int getRowCount() {	
		return cupons.size();
	}
	
	@Override
	public int getColumnCount() {
		return QTDE_COLUNAS;
	}
	
	@Override
	public String getColumnName(int column) {
		if (column == 0) {
			return "ID";
		} else if (column == 1) {
			return "Valor";
		} else if (column == 2) {
			return "Validade";
		} else if (column == 3) {
			return "Código";
		}
		throw new IllegalArgumentException("Indíce inválido");
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex == 0) {
			return cupons.get(rowIndex).getId();
		} else if (columnIndex == 1) {
			return cupons.get(rowIndex).getValor();
		} else if (columnIndex == 2) {
			return cupons.get(rowIndex).getValidade();
		} else if (columnIndex == 3) {
			return cupons.get(rowIndex).getCodigo();
		}
		throw new IllegalArgumentException("Índice inválido");
	}
	
	public Cupom getPor(int rowIndex) {
		return cupons.get(rowIndex);
	}	

}
