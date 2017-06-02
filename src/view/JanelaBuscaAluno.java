package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JTextField;

import controller.Sistema;
import controller.TableModelAcademia;
import model.Aluno;
import model.Treino;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JanelaBuscaAluno extends JInternalFrame implements ActionListener {

	private JTextField textFieldNome = new JTextField();
	private JLabel JlabelNome = new JLabel("Digite o nome do aluno");
	private JScrollPane scrollPane = new JScrollPane();
	private JTable table = new JTable();
	private JButton botaoPesquisar = new JButton("Pesquisar");
	private JButton botaoListaTodosAlunos = new JButton("Listar todos os alunos");
	private JButton botaoCancelar = new JButton("Cancelar");
	private JButton botaoEditar = new JButton("Editar");
	private JButton botaoFicha = new JButton("Ficha");
	private JButton botaoAtribuirTreino = new JButton("Mudar/Atribuir Treino");

	public JanelaBuscaAluno() {

		setIconifiable(true);
		setBounds(64, 36, 668, 410);
		getContentPane().setLayout(null);
		
		JlabelNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JlabelNome.setBounds(12, 35, 183, 16);
		getContentPane().add(JlabelNome);
		
		textFieldNome.setBounds(12, 57, 320, 22);
		getContentPane().add(textFieldNome);

		botaoPesquisar.setBounds(344, 56, 97, 25);
		getContentPane().add(botaoPesquisar);
		botaoPesquisar.addActionListener(this);

		table.setModel(new TableModelAcademia(new String[] { "Nome", "Matricula", "Contato" }, 0, 3));
		scrollPane.setViewportView(table);
		scrollPane.setAutoscrolls(true);
		table.setAutoCreateRowSorter(true);
		scrollPane.setBounds(12, 92, 628, 229);
		getContentPane().add(scrollPane);
		
		JLabel enfeite1 = new JLabel("BUSCA POR NOME");
		enfeite1.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		enfeite1.setBounds(12, 13, 227, 22);
		getContentPane().add(enfeite1);
		
		botaoListaTodosAlunos.setBounds(453, 56, 187, 25);
		getContentPane().add(botaoListaTodosAlunos);
		botaoListaTodosAlunos.addActionListener(this);
		
		botaoCancelar.setBounds(543, 336, 97, 25);
		getContentPane().add(botaoCancelar);
		botaoCancelar.addActionListener(this);
		
		botaoEditar.setBounds(436, 336, 97, 25);
		getContentPane().add(botaoEditar);
		botaoEditar.addActionListener(this);
		
		botaoFicha.setBounds(326, 336, 97, 25);
		getContentPane().add(botaoFicha);
		botaoFicha.addActionListener(this);
		
		botaoAtribuirTreino.setBounds(12, 336, 197, 25);
		getContentPane().add(botaoAtribuirTreino);
		botaoAtribuirTreino.addActionListener(this);

		botaoApagar.setBounds(219, 336, 97, 25);
		getContentPane().add(botaoApagar);
		botaoApagar.addActionListener(this);
	}

	public void listar() {
		ArrayList<Aluno> alunos = controller.Sistema.getGerenteAluno().todosAlunos();
		table.setModel(new TableModelAcademia(new String[] { "Nome", "Matricula", "Contato" },
				alunos.size(), 3));
		for (int i = 0; i < alunos.size(); i++) {
			table.setValueAt(alunos.get(i).getNome(), i, 0);
			table.setValueAt(alunos.get(i).getMatricula(), i, 1);
			table.setValueAt(alunos.get(i).getContato().getTelefone(), i, 2);
		}
	}

	Editar editar = new Editar();
	Ficha ficha = new Ficha();
	private final JButton botaoApagar = new JButton("Apagar");

	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == botaoPesquisar) {
			String nome = textFieldNome.getText();
			Aluno aluno = new Aluno("");
			if (Sistema.getGerenteAluno().ExisteAluno(nome)) {
				table.setModel(new TableModelAcademia(new String[] { "Nome", "Matricula", "Contato" }, 1, 3));
				aluno = Sistema.getGerenteAluno().buscarAluno(nome);
				table.setValueAt(aluno.getNome(), 0, 0);
				table.setValueAt(aluno.getMatricula(), 0, 1);
				table.setValueAt(aluno.getContato().getTelefone(), 0, 2);

			} else {
				JOptionPane.showMessageDialog(null, "Usuario não existe");
			}
		}

		if (evento.getSource() == botaoListaTodosAlunos) {
			table.setModel(new TableModelAcademia(new String[] { "Nome", "Matricula", "Contato" },
					Sistema.getGerenteAluno().todosAlunos().size(), 3));
			Iterator<Aluno> it = Sistema.getGerenteAluno().todosAlunos().iterator();
			int i = 0;
			while (it.hasNext()) {
				Aluno a = it.next();
				table.setValueAt(a.getNome(), i, 0);
				table.setValueAt(a.getMatricula(), i, 1);
				table.setValueAt(a.getContato(), i++, 2);
			}
			
			/*
			for (int i = 0; i < Sistema.getGerenteAluno().todosAlunos().size(); i++) {
				table.setValueAt(Sistema.getGerenteAluno().todosAlunos().get(i).getNome(), i, 0);
				table.setValueAt(Sistema.getGerenteAluno().todosAlunos().get(i).getMatricula(), i, 1);
				table.setValueAt(Sistema.getGerenteAluno().todosAlunos().get(i).getContato().getTelefone(), i, 2);
			}
			*/
		}

		if (evento.getSource() == botaoEditar) {
			setTitle("BUSCAR ALUNO");
			editar.setVisible(true);
			String nome = table.getValueAt(table.getSelectedRow(), 0).toString();
			Aluno aluno = new Aluno("");
			aluno = Sistema.getGerenteAluno().buscarAluno(nome);
			editar.textFieldNome.setText(aluno.getNome());
			editar.textFieldNumerodeIndentificacao.setText(aluno.getMatricula());
			editar.textFieldEstado.setText(aluno.getEndereco().getEstado());
			editar.textFieldCidade.setText(aluno.getEndereco().getCidade());
			editar.textFieldNumeroDaCasa.setText(aluno.getEndereco().getNumeroDaCasa());
			editar.textFieldDataDeNascimento.setText(aluno.getDataDeNascimento());
			editar.textFieldContato.setText(aluno.getContato().getTelefone());
			editar.textFieldRua.setText(aluno.getEndereco().getRua());
			editar.num = Sistema.getGerenteAluno().buscarIndexAluno(nome);
			listar();
		}

		if (evento.getSource() == botaoApagar) {
			Sistema.getGerenteAluno().removePessoa(table.getSelectedRow());
			listar();
		}

		if (evento.getSource() == botaoCancelar) {
			setVisible(false);
		}

		if (evento.getSource() == botaoFicha) {
			Janela.desktopPane.add(ficha);
			ficha.setVisible(true);
			String nome = table.getValueAt(table.getSelectedRow(), 0).toString();
			Aluno aluno = new Aluno("");
			aluno = Sistema.getGerenteAluno().buscarAluno(nome);
			ficha.LabelNumeroDeIndetificacao.setText(aluno.getMatricula());
			ficha.labelNome.setText(aluno.getNome());
			ficha.LabelEstado.setText(aluno.getEndereco().getEstado());
			ficha.labelDataDeNascimento.setText(aluno.getDataDeNascimento());
			ficha.labelRua.setText(aluno.getEndereco().getRua());
			ficha.labelTelefone.setText(aluno.getContato().getTelefone());
			ficha.LabelNumeroDaCasa.setText(aluno.getEndereco().getNumeroDaCasa());
			ficha.LabelEmail.setText(aluno.getContato().getEmail());
			ficha.labelCidade.setText(aluno.getEndereco().getCidade());
		}
		if (evento.getSource() == botaoAtribuirTreino) {
			int i = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do treino: "));
			Treino t = Sistema.getGerenteTreino().getTreino(i);
			if(t != null){
				Sistema.getGerenteAluno().todosAlunos().get(table.getSelectedRow()).setTreino(t);
			}
		}
	}

	public static void main(String[] args) {
		new JanelaBuscaAluno();
	}
}
