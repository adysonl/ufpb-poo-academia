package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import controller.Sistema;

import javax.swing.JDesktopPane;
import java.awt.Color;

public class Janela extends JFrame implements ActionListener {

	static JDesktopPane desktopPane = new JDesktopPane();
	private JPanel contentPane = new JPanel();
	private JMenuBar menuBar = new JMenuBar();

	private JMenu menuAluno = new JMenu("Aluno");
	private JMenu menuProfessor = new JMenu("Professor");
	private JMenu menuTreino = new JMenu("Treino");

	private JMenuItem itemCadastraAluno = new JMenuItem("Cadastrar Aluno");
	private JMenuItem itemBuscaAluno = new JMenuItem("Buscar Aluno");

	private JMenuItem itemCadastraProfessor = new JMenuItem("Cadastrar Professor");
	private JMenuItem itemBuscaProfessor = new JMenuItem("Buscar Professor");

	private JMenuItem itemCadastrarTreino = new JMenuItem("Cadastrar Treino");
	private JMenuItem itemCadastrarExercicio = new JMenuItem("Cadastrar Exercicio");
	
	private int quantTreinos = 0;
	protected String srt = Integer.toString(quantTreinos) + " Treinos Cadastrados";
	protected JLabel labelTreinos = new JLabel("0 Treinos Cadastrados!");
	JanelaFacade janelaFacade = new JanelaFacade();

	public Janela() {
		setTitle("ACADEMIA XXXXXX");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setJMenuBar(menuBar);

		menuBar.add(menuAluno);

		itemCadastraAluno.addActionListener(this);
		itemBuscaAluno.addActionListener(this);

		menuAluno.add(itemCadastraAluno);
		menuAluno.add(itemBuscaAluno);

		menuBar.add(menuProfessor);

		itemCadastraProfessor.addActionListener(this);
		itemBuscaProfessor.addActionListener(this);

		menuProfessor.add(itemCadastraProfessor);
		menuProfessor.add(itemBuscaProfessor);

		menuBar.add(menuTreino);

		menuTreino.add(itemCadastrarTreino);
		menuTreino.add(itemCadastrarExercicio);

		itemCadastrarExercicio.addActionListener(this);
		itemCadastrarTreino.addActionListener(this);
		desktopPane.setBackground(Color.WHITE);

		desktopPane.setBounds(0, 0, 956, 463);
		desktopPane.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
		desktopPane.add(janelaFacade.frameCadastroAluno);
		desktopPane.add(janelaFacade.frameBuscaAluno);
		desktopPane.add(janelaFacade.frameCadastrarTreino);
		desktopPane.add(janelaFacade.frameCadastrarExercicio);
		desktopPane.add(janelaFacade.frameCadastroProfessor);
		desktopPane.add(janelaFacade.frameBuscaProfessor);

		contentPane.add(desktopPane);
		labelTreinos.setBounds(824, 438, 122, 14);
		desktopPane.add(labelTreinos);
		setSize(974, 536);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent evento) {
	
		
		if (evento.getSource() == itemCadastraProfessor)
			janelaFacade.frameCadastroProfessor.setVisible(true);
		if (evento.getSource() == itemBuscaProfessor)
			janelaFacade.frameBuscaProfessor.setVisible(true);
		if (evento.getSource() == itemCadastraAluno)
			janelaFacade.frameCadastroAluno.setVisible(true);
		if (evento.getSource() == itemBuscaAluno)
			janelaFacade.frameBuscaAluno.setVisible(true);
		if (evento.getSource() == itemCadastrarTreino)
			janelaFacade.frameCadastrarTreino.setVisible(true);
		if (evento.getSource() == itemCadastrarExercicio)
			janelaFacade.frameCadastrarExercicio.setVisible(true);
	}

	public void incrementaTreinos() {
		quantTreinos++;
		labelTreinos.setText(Integer.toString(quantTreinos)+" Treinos Cadastrados");
	}
}
