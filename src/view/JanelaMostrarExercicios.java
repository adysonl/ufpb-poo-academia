package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.TableModelAcademia;

import javax.swing.JLabel;
import java.awt.Font;

public class JanelaMostrarExercicios extends JInternalFrame implements ActionListener {

	private JTable table = new JTable();
	JScrollPane scrollPane = new JScrollPane();

	public JanelaMostrarExercicios() {
		setTitle("EXERCÍCIOS");
		setIconifiable(true);
		setBounds(64, 36, 307, 304);
		getContentPane().setLayout(null);

		table.setModel(new TableModelAcademia(new String[] { "Nome", "Serie", "Grupo Muscular" }, 0, 3));
		scrollPane.setBounds(12, 48, 267, 193);
		scrollPane.setViewportView(table);
		getContentPane().add(scrollPane);

		JLabel lblExercicio = new JLabel("Exercicio");
		lblExercicio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblExercicio.setBounds(84, 13, 113, 22);
		getContentPane().add(lblExercicio);

	}

	public void actionPerformed(ActionEvent evento) {
		
	}

	public static void main(String[] args) {
		new JanelaMostrarExercicios();
	}
}
