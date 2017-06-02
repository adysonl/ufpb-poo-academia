package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.Sistema;
import controller.TableModelAcademia;
import controller.TableModelExercico;

import javax.swing.JButton;

public class JanelaBuscaExercicio extends JInternalFrame implements ActionListener {
	private JTable table = new JTable();
	JScrollPane scrollPane = new JScrollPane();
	JButton butaoCancelar = new JButton("Cancelar");
	JButton btnListar = new JButton("Listar");
	JButton btnAdicionar = new JButton("Adicionar");
	
	public JanelaBuscaExercicio() {
		setIconifiable(true);
		setBounds(64, 36, 428, 309);
		getContentPane().setLayout(null);
	
		scrollPane.setViewportView(table);
		scrollPane.setAutoscrolls(true);
		table.setAutoCreateRowSorter(true);
		scrollPane.setBounds(12, 13, 388, 212);
		getContentPane().add(scrollPane);	
		table.setModel(new TableModelExercico(new String[] { "Nome", "Serie", "Grupo Muscular" }, 0, 3));
		
		
		butaoCancelar.setBounds(303, 238, 97, 25);
		getContentPane().add(butaoCancelar);
		butaoCancelar.addActionListener(this);
		
		
		btnListar.setBounds(194, 238, 97, 25);
		getContentPane().add(btnListar);
		btnListar.addActionListener(this);
		
		btnAdicionar.setBounds(85, 238, 97, 25);
		getContentPane().add(btnAdicionar);
		btnAdicionar.addActionListener(this);

	}
	
	public void listar(){
		table.setModel(new TableModelAcademia(new String[] { "Nome", "Serie", "Grupo Muscular"  }, Sistema.getGerenteExercicio().todosExercicios().size(), 3));
		for (int i = 0; i < Sistema.getGerenteExercicio().todosExercicios().size(); i++) {
			table.setValueAt(Sistema.getGerenteExercicio().todosExercicios().get(i).getNome(), i, 0);
			table.setValueAt(Sistema.getGerenteExercicio().todosExercicios().get(i).getSerie(), i, 1);
			table.setValueAt(Sistema.getGerenteExercicio().todosExercicios().get(i).getGrupoMuscular(), i, 2);
		}
	}
	
	public void actionPerformed(ActionEvent evento) {
		if(evento.getSource() == butaoCancelar){
			setVisible(false);
		}
		if(evento.getSource() == btnListar){
			listar();
		}
		if(evento.getSource() == btnAdicionar){
			Sistema.getJanela().janelaFacade.frameCadastrarTreino.treino.getExercicios().add(Sistema.getGerenteExercicio().todosExercicios().get(table.getSelectedRow()));
		}
		
	}
	public static void main(String[] args) {
		new JanelaBuscaExercicio();
	}	
}
