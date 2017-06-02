package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.Sistema;
import model.Exercicio;
import model.Treino;

public class JanelaCadastrarExercicio extends JInternalFrame implements ActionListener{

	JButton butaoCancelar = new JButton("Cancelar");
	private JTextField textFieldNome = new JTextField();
	private JTextField textFieldSeries = new JTextField();
	private JTextField textFieldGrupoMuscular = new JTextField();
	JLabel jLabelNome = new JLabel("Nome");
	JLabel jLabelSeries = new JLabel("Series");
	JLabel jlabelGrupoMuscular = new JLabel("Grupo Muscular");
	
	JButton butaoCadastrar = new JButton("Cadastrar");
	
	public JanelaCadastrarExercicio() {
		setIconifiable(true);
		setBounds(64, 36, 363, 139);
		getContentPane().setLayout(null);
		
		jLabelNome.setBounds(12, 13, 56, 16);
		getContentPane().add(jLabelNome);
		textFieldNome.setBounds(57, 10, 267, 22);
		getContentPane().add(textFieldNome);
		
		jLabelSeries.setBounds(12, 45, 56, 16);
		getContentPane().add(jLabelSeries);
		textFieldSeries.setBounds(57, 42, 34, 22);
		getContentPane().add(textFieldSeries);
		
		jlabelGrupoMuscular.setBounds(103, 45, 97, 16);
		getContentPane().add(jlabelGrupoMuscular);
		textFieldGrupoMuscular.setBounds(203, 42, 138, 22);
		getContentPane().add(textFieldGrupoMuscular);
		
		butaoCancelar.setBounds(244, 74, 97, 25);
		getContentPane().add(butaoCancelar);
		butaoCancelar.addActionListener(this);
		
		butaoCadastrar.setBounds(135, 74, 97, 25);
		getContentPane().add(butaoCadastrar);
		butaoCadastrar.addActionListener(this);
		
	} 
	public void setarTextFilds(){
		textFieldNome.setText(null);
		textFieldGrupoMuscular.setText(null);
		textFieldSeries.setText(null);
	}
	public void actionPerformed(ActionEvent evento) {
		if(evento.getSource() == butaoCadastrar){
			String nome = textFieldNome.getText();
			int numeroDeSerie = Integer.parseInt(textFieldSeries.getText());
			String grupoMuscular = textFieldGrupoMuscular.getText();
			Exercicio exercicio = new Exercicio();
			exercicio.setNome(nome);
			exercicio.setSerie(numeroDeSerie);
			exercicio.setGrupoMuscular(grupoMuscular);
			Sistema.getGerenteExercicio().cadastrarExercicio(exercicio);
			int opcao = JOptionPane.showConfirmDialog(null, "Cadastrado com sucesso!\nDeseja cadastrar outro exercicío?");
			switch (opcao){
				case 0:
					setarTextFilds();
					break;
				case 1:
					setVisible(false);
					break;
				case 2:
					setVisible(false);
					break;
			}
		}
		if(evento.getSource() == butaoCancelar){
			setVisible(false);
		}
	}
	public static void main(String[] args) {
		new JanelaCadastrarTreino();
	}
}
