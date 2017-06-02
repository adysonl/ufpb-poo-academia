package controller;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class TableModelExercico extends AbstractTableModel {

	private String[] tituloColunas;
	private Object[][] linhas;
	private int numerosLinhas, numerosColunas;

	public TableModelExercico(String[] tituloColunas, int numLinhas, int numColunas) {
		this.tituloColunas = tituloColunas;
		this.linhas = new Object[numLinhas][numColunas];
		numerosLinhas = numLinhas;
		numerosColunas = numColunas;
	}
	public String getColumnName(int col) {
        return tituloColunas[col];
    }
	public int getColumnCount() {
		return numerosColunas;
	}

	public int getRowCount() {
		return numerosLinhas;
	}

	public Object getValueAt(int numerosLinha, int numerosColuna) {
		return linhas[numerosLinha][numerosColuna];
	}
	
	 public void setValueAt(Object valor, int linha, int coluna) {
		 	linhas[linha][coluna] = valor.toString();
	        fireTableCellUpdated(linha, coluna);
	    }
}
