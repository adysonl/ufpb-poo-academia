package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.Sistema;
import controller.TableModelAcademia;
import model.Aluno;
import model.Professor;

import javax.swing.JButton;

public class JanelaBuscaProfessor extends JInternalFrame implements ActionListener {

	
	private JTextField textFieldNome = new JTextField();
	private JLabel JlabelNome = new JLabel("Nome do Professor");
	private JButton botaoPesquisar = new JButton("Pesquisar");
	private JScrollPane scrollPane = new JScrollPane();
	private JTable table = new JTable();
	JButton botaoListarTodos = new JButton("Listar todos");
	private final JButton butaoCancelar = new JButton("Cancelar");
	private JButton botaoApagar = new JButton("Apagar");
	private final JButton butaoEditar = new JButton("Editar");
	private final JButton butaoFicha = new JButton("Ficha");
	Editar editar = new Editar();
	private final JButton butaoApagar = new JButton("Apagar");
	
	public JanelaBuscaProfessor() {
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
		
		table.setModel(new TableModelAcademia(new String[] { "Nome", "CREF", "Contato", "  " }, 1, 4));
		scrollPane.setViewportView(table);
		scrollPane.setAutoscrolls(true);
		table.setAutoCreateRowSorter(true);
		
		scrollPane.setBounds(12, 92, 628, 229);
		getContentPane().add(scrollPane);
		
		JLabel enfeite1 = new JLabel("Busca por nome");
		enfeite1.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		enfeite1.setBounds(12, 13, 227, 22);
		getContentPane().add(enfeite1);
		
		botaoListarTodos.setBounds(453, 56, 187, 25);
		getContentPane().add(botaoListarTodos);
		butaoCancelar.setBounds(543, 336, 97, 25);
		butaoCancelar.addActionListener(this);
		
		butaoEditar.setBounds(436, 336, 97, 25);
		getContentPane().add(butaoEditar);
		butaoEditar.addActionListener(this);
		
		butaoFicha.setBounds(326, 336, 97, 25);
		getContentPane().add(butaoFicha);
		butaoFicha.addActionListener(this);
		
		butaoApagar.setBounds(219, 336, 97, 25);
		getContentPane().add(butaoApagar);
		butaoApagar.addActionListener(this);
	
		
		
		getContentPane().add(butaoCancelar);
		botaoListarTodos.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent evento) {
		if(evento.getSource() == botaoPesquisar){
			String nome = textFieldNome.getText();
			Professor professor = new Professor("");
			if(Sistema.getGerenteProfessor().ExisteProfessor(nome)){
				professor = Sistema.getGerenteProfessor().buscarProfessor(nome);
				table.setValueAt(professor.getNome(),  0, 0);
				table.setValueAt(professor.getCref(), 0, 1);
				table.setValueAt(professor.getContato().getTelefone(), 0, 2);
				table.setValueAt("del", 0, 3);
				
			}else
				JOptionPane.showMessageDialog(null, "Usuario não existe");
		}
		if(evento.getSource() == botaoListarTodos){
			table.setModel(new TableModelAcademia(new String[] { "Nome", "CREF", "Contato", "" }, Sistema.getGerenteProfessor().todosProfessores().size(), 4));
			for (int i = 0; i < Sistema.getGerenteProfessor().todosProfessores().size(); i++) {
				table.setValueAt(Sistema.getGerenteProfessor().todosProfessores().get(i).getNome(), i, 0);
				table.setValueAt(Sistema.getGerenteProfessor().todosProfessores().get(i).getCref(), i, 1);
				table.setValueAt(Sistema.getGerenteProfessor().todosProfessores().get(i).getContato().getTelefone(), i, 2);
				table.setValueAt("del", i, 3);

			}
		}
		if(evento.getSource() == butaoCancelar){
			setVisible(false);
		}
		if(evento.getSource() == butaoEditar){
			editar.setVisible(true);
			String nome = table.getValueAt(table.getSelectedRow(), 0).toString();
			Professor professor = new Professor("");
			professor = Sistema.getGerenteProfessor().buscarProfessor(nome);
			editar.textFieldNome.setText(professor.getNome());
			editar.textFieldNumerodeIndentificacao.setText(professor.getCref());
			editar.textFieldEstado.setText(professor.getEndereco().getEstado());
			editar.textFieldCidade.setText(professor.getEndereco().getCidade());
			editar.textFieldNumeroDaCasa.setText(professor.getEndereco().getNumeroDaCasa());
			editar.textFieldDataDeNascimento.setText(professor.getDataDeNascimento());
			editar.textFieldContato.setText(professor.getContato().getTelefone());
			editar.textFieldRua.setText(professor.getEndereco().getRua());
			editar.num = Sistema.getGerenteProfessor().buscarIndexProfessor(nome);
			listar();
		}
		
		if(evento.getSource() == butaoApagar){
			Sistema.getGerenteProfessor().removePessoa(table.getSelectedRow());
			listar();
		}
		
		
		if(evento.getSource() == butaoFicha){
			setTitle("BUSCAR PROFESSOR");
			setVisible(false);
			Ficha ficha = new Ficha();
			Janela.desktopPane.add(ficha);
			ficha.setVisible(true);
			String nome = table.getValueAt(table.getSelectedRow(), 0).toString();
			Professor p = new Professor("");
			p = Sistema.getGerenteProfessor().buscarProfessor(nome);
			ficha.LabelNumeroDeIndetificacao.setText(p.getCref());
			ficha.labelNome.setText(p.getNome());
			ficha.LabelEstado.setText(p.getEndereco().getEstado());
			ficha.labelDataDeNascimento.setText(p.getDataDeNascimento());
			ficha.labelRua.setText(p.getEndereco().getRua());
			ficha.labelTelefone.setText(p.getContato().getTelefone());
			ficha.LabelNumeroDaCasa.setText(p.getEndereco().getNumeroDaCasa());
			ficha.LabelEmail.setText(p.getContato().getEmail());
			ficha.labelCidade.setText(p.getEndereco().getCidade());
		}
	}
	public static void main(String[] args) {
		new JanelaBuscaProfessor();
	}
	
	public void listar(){
		table.setModel(new TableModelAcademia(new String[] { "Nome", "Matricula", "Contato" }, Sistema.getGerenteProfessor().todosProfessores().size(), 3));
		for (int i = 0; i < Sistema.getGerenteProfessor().todosProfessores().size(); i++) {
			table.setValueAt(Sistema.getGerenteProfessor().todosProfessores().get(i).getNome(), i, 0);
			table.setValueAt(Sistema.getGerenteProfessor().todosProfessores().get(i).getCref(), i, 1);
			table.setValueAt(Sistema.getGerenteProfessor().todosProfessores().get(i).getContato().getTelefone(), i, 2);
		}
}
}
