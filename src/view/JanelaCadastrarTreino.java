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
import model.Treino;

public class JanelaCadastrarTreino extends JInternalFrame implements ActionListener{

	JButton butaoCancelar = new JButton("Cancelar");
	private JTextField textFieldNome = new JTextField();
	private JTextField textFieldDescricao = new JTextField();
	JLabel JlabelNome = new JLabel("Nome");
	JLabel JlabelDescricao = new JLabel("Descricao");
	JButton butaoBuscarExercecio = new JButton("Buscar Exercecio"), botaoCadastrar = new JButton("Cadastrar");
	JanelaBuscaExercicio janelaBuscaExercicio =  new JanelaBuscaExercicio();
	protected Treino treino = new Treino();
	
	public JanelaCadastrarTreino() {
		setTitle("TREINOS");
		setIconifiable(true);
		setBounds(64, 36, 282, 289);
		getContentPane().setLayout(null);
		
		butaoCancelar.setBounds(150, 215, 97, 25);
		getContentPane().add(butaoCancelar);
		butaoCancelar.addActionListener(this);
		
		JlabelNome.setBounds(12, 16, 56, 16);
		getContentPane().add(JlabelNome);
		textFieldNome.setBounds(80, 13, 167, 22);
		getContentPane().add(textFieldNome);
		
		JlabelDescricao.setBounds(12, 86, 70, 16);
		getContentPane().add(JlabelDescricao);
		textFieldDescricao.setBounds(12, 115, 235, 87);
		getContentPane().add(textFieldDescricao);
		
		
		butaoBuscarExercecio.setBounds(12, 48, 137, 25);
		getContentPane().add(butaoBuscarExercecio);
		butaoBuscarExercecio.addActionListener(this);
		
		botaoCadastrar.setBounds(12, 215, 128, 25);
		getContentPane().add(botaoCadastrar);
		botaoCadastrar.addActionListener(this);

	} 
	public void actionPerformed(ActionEvent evento) {
		if(evento.getSource() == butaoBuscarExercecio){
			Janela.desktopPane.add(janelaBuscaExercicio);
			janelaBuscaExercicio.setVisible(true);
		}
		if(evento.getSource() == butaoCancelar){
			setVisible(false);
		}
		
		if(evento.getSource() == botaoCadastrar){
			treino.setNome(textFieldNome.getText());
			treino.setDescricao(textFieldDescricao.getText());
			Sistema.getGerenteTreino().cadastrarTreino(treino);
			Sistema.getJanela().incrementaTreinos();
			int i = JOptionPane.showConfirmDialog(null, "Cadastrado com sucesso! Deseja Cadastrar outro Treino?");
			switch (i){
			case 0: 
				textFieldDescricao.setText("");
				textFieldNome.setText("");
			case 1:
				setVisible(false);
			case 2: 
				setVisible(false);
			}
		}
	}
	public static void main(String[] args) {
		new JanelaCadastrarTreino();
	}
}
