package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.Sistema;
import model.Aluno;
import model.Endereco;

public class JanelaCadastroAluno extends JInternalFrame implements ActionListener {

	private JTextField textFieldNumerodeIndentificacao = new JTextField();
	private JLabel JLabelNumerodeIndentificacao = new JLabel("N\u00BA de Indentificacao");
	private JLabel jLabelNome = new JLabel("Nome");
	private JTextField textFieldNome = new JTextField();
	private JLabel jLabelEstado = new JLabel("Estado");
	private JTextField textFieldEstado = new JTextField();
	private JLabel jLabelCidade = new JLabel("Cidade");
	private JTextField textFieldCidade = new JTextField();
	private JLabel jLabelSexo = new JLabel("Sexo");
	String[] sexos = { "masculino", "feminino"};
	private JComboBox comboBoxSexo = new JComboBox(sexos);
	private JLabel jLabelNumeroDaCasa = new JLabel("N\u00BA da Casa");
	private JTextField textFieldNumeroDaCasa = new JTextField();
	private JLabel jLabelDataDeNascimento = new JLabel("Data de Nascimento");
	private JTextField textFieldDataDeNascimento = new JTextField();
	private JLabel jLabelContato = new JLabel("Telefone");
	private JTextField textFieldContato = new JTextField();
	private JLabel jLabelRua = new JLabel("Rua");
	private JTextField textFieldRua = new JTextField();
	private JLabel jLabelEmail = new JLabel("Email");
	private JTextField textFieldEmail = new JTextField();
	
	private JButton botaoCancelarAluno = new JButton("Cancelar");
	private JButton botaoAdicionarAluno = new JButton("Adicionar");
	private Aluno aluno;

	public JanelaCadastroAluno() {
		
		setTitle("CADASTRO DE ALUNO");
		setIconifiable(true);
		setTitle("Cadastrar Aluno");
		setBounds(64, 36, 668, 410);

		JLabelNumerodeIndentificacao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabelNumerodeIndentificacao.setBounds(12, 80, 133, 16);
		getContentPane().add(JLabelNumerodeIndentificacao);
		textFieldNumerodeIndentificacao.setBounds(157, 74, 175, 22);
		getContentPane().add(textFieldNumerodeIndentificacao);
		
		jLabelNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jLabelNome.setBounds(12, 109, 63, 16);
		getContentPane().add(jLabelNome);
		textFieldNome.setBounds(157, 103, 241, 22);
		getContentPane().add(textFieldNome);
		
		jLabelEstado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jLabelEstado.setBounds(12, 200, 56, 22);
		getContentPane().add(jLabelEstado);
		textFieldEstado.setBounds(97, 200, 155, 22);
		getContentPane().add(textFieldEstado);
		
		jLabelCidade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jLabelCidade.setBounds(264, 200, 56, 22);
		getContentPane().add(jLabelCidade);
		textFieldCidade.setBounds(316, 201, 176, 22);
		getContentPane().add(textFieldCidade);
		
		jLabelSexo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jLabelSexo.setBounds(504, 200, 41, 22);
		getContentPane().add(jLabelSexo);
		comboBoxSexo.setBounds(557, 201, 87, 22);
		getContentPane().add(comboBoxSexo);
		
		jLabelNumeroDaCasa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jLabelNumeroDaCasa.setBounds(12, 231, 75, 22);
		getContentPane().add(jLabelNumeroDaCasa);
		textFieldNumeroDaCasa.setBounds(97, 231, 73, 22);
		getContentPane().add(textFieldNumeroDaCasa);
		
		jLabelDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jLabelDataDeNascimento.setBounds(182, 231, 133, 22);
		getContentPane().add(jLabelDataDeNascimento);
		textFieldDataDeNascimento.setBounds(327, 231, 116, 22);
		getContentPane().add(textFieldDataDeNascimento);
		
		jLabelContato.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jLabelContato.setBounds(455, 231, 56, 22);
		getContentPane().add(jLabelContato);
		textFieldContato.setBounds(523, 231, 121, 22);
		getContentPane().add(textFieldContato);
		
		jLabelEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jLabelEmail.setBounds(12, 266, 41, 22);
		getContentPane().add(jLabelEmail);
		textFieldEmail.setBounds(97, 266, 266, 22);
		getContentPane().add(textFieldEmail);
		
		jLabelRua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jLabelRua.setBounds(375, 266, 41, 22);
		getContentPane().add(jLabelRua);
		textFieldRua.setBounds(426, 266, 218, 22);
		getContentPane().add(textFieldRua);
		
		JLabel enfeite1 = new JLabel("Dados de Indentifica\u00E7ao");
		enfeite1.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		enfeite1.setBounds(12, 24, 227, 22);
		getContentPane().add(enfeite1);
		
		JLabel enfeite2 = new JLabel("Dados Generico");
		enfeite2.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		enfeite2.setBounds(12, 161, 227, 22);
		getContentPane().add(enfeite2);
		
		botaoAdicionarAluno.setBounds(433, 325, 97, 25);
		getContentPane().add(botaoAdicionarAluno);
		botaoAdicionarAluno.addActionListener(this);
		
		botaoCancelarAluno.setBounds(542, 325, 97, 25);
		botaoCancelarAluno.addActionListener(this);
		getContentPane().add(botaoCancelarAluno);
		
		getContentPane().setLayout(null);
		setVisible(false);
	}
	public void setarTextFilds(){
		textFieldNome.setText(null);
		textFieldNumerodeIndentificacao.setText(null);
		textFieldEstado.setText(null);
		textFieldCidade.setText(null);
		textFieldNumeroDaCasa.setText(null);
		textFieldDataDeNascimento.setText(null);
		textFieldContato.setText(null);
		textFieldRua.setText(null);
		textFieldRua.setText(null);
	}
	
	public void actionPerformed(ActionEvent evento) {
		if(evento.getSource() == botaoAdicionarAluno){
			String nome = textFieldNome.getText();
			String numeroIndetificacao = textFieldNumerodeIndentificacao.getText();
			String estado = textFieldEstado.getText();
			String cidade = textFieldCidade.getText();
//			JComboBox comboBoxSexo = new JComboBox(sexos);
			String numeroDaCasa = textFieldNumeroDaCasa.getText();
			String dataDeNascimento = textFieldDataDeNascimento.getText();
			String contato = textFieldContato.getText();
			String rua = textFieldRua.getText();
			String email =textFieldEmail.getText();
			if(nome.length() == 0){
				JOptionPane.showMessageDialog(null, "Digite seu nome");
			}else{
				aluno = new Aluno(nome);
				aluno.setMatricula(numeroIndetificacao);
				aluno.setEndereco(new Endereco(cidade, estado, rua, numeroDaCasa));
				aluno.getContato().setEmail(email);
				aluno.getContato().setTelefone(contato);
				aluno.setDataDeNascimento(dataDeNascimento);
				Sistema.getGerenteAluno().cadastrarAluno(aluno);
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
				int opcao = JOptionPane.showConfirmDialog(null, "Deseja cadastrar outro alunos?");
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
		}
		if(evento.getSource() == botaoCancelarAluno){
			setVisible(false);
		}
	}
	
}
