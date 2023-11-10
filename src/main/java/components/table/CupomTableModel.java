package components.table;

import javax.swing.table.AbstractTableModel;

public class CupomTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	
	private final int QTDE_COLUNAS = 4;

	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getColumnCount() {
		return QTDE_COLUNAS;
	}
	
	@Override
	public String getColumnName(int column) {
		if (column == 0) {
			return "ID";
		}else if (column == 1) {
			return "Valor";
		}else if (column == 2) {
			return "Validade";
		}else if (column == 3) {
			return "Código";
		}
		throw new IllegalArgumentException("Indíce inválido");
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
