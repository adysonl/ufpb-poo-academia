package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Sistema;
import model.Aluno;
import model.Endereco;

public class Editar extends JFrame implements ActionListener{

	private JPanel contentPane = new JPanel();;
	
	JTextField textFieldNumerodeIndentificacao = new JTextField();
	JLabel JLabelNumerodeIndentificacao = new JLabel("N\u00BA de Indentificacao");
	JLabel jLabelNome = new JLabel("Nome");
	JTextField textFieldNome = new JTextField();
	JLabel jLabelEstado = new JLabel("Estado");
	JTextField textFieldEstado = new JTextField();
	JLabel jLabelCidade = new JLabel("Cidade");
	JTextField textFieldCidade = new JTextField();
	JLabel jLabelSexo = new JLabel("Sexo");
	String[] sexos = { "masculino", "feminino"};
	JComboBox comboBoxSexo = new JComboBox(sexos);
	JLabel jLabelNumeroDaCasa = new JLabel("N\u00BA da Casa");
	JTextField textFieldNumeroDaCasa = new JTextField();
	JLabel jLabelDataDeNascimento = new JLabel("Data de Nascimento");
	JTextField textFieldDataDeNascimento = new JTextField();
	JLabel jLabelContato = new JLabel("Telefone");
	JTextField textFieldContato = new JTextField();
	JLabel jLabelRua = new JLabel("Rua");
	JTextField textFieldRua = new JTextField();
	JLabel jLabelEmail = new JLabel("Email");
	JTextField textFieldEmail = new JTextField();
	JButton butaoCancelarAluno = new JButton("Cancelar");
	JButton butaoAdicionarAluno = new JButton("Adicionar");
	final JButton botaoConfirmar = new JButton("Editar");
	int num;
	
	public Editar() {
		setTitle("Editar");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		///////////////////////////////////
		JLabelNumerodeIndentificacao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabelNumerodeIndentificacao.setBounds(12, 13, 133, 16);
		getContentPane().add(JLabelNumerodeIndentificacao);
		textFieldNumerodeIndentificacao.setBounds(157, 11, 241, 22);
		getContentPane().add(textFieldNumerodeIndentificacao);
		
		jLabelNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jLabelNome.setBounds(12, 42, 63, 16);
		getContentPane().add(jLabelNome);
		textFieldNome.setBounds(75, 42, 241, 22);
		getContentPane().add(textFieldNome);
		
		jLabelEstado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jLabelEstado.setBounds(327, 39, 56, 22);
		getContentPane().add(jLabelEstado);
		textFieldEstado.setBounds(395, 40, 164, 22);
		getContentPane().add(textFieldEstado);
		
		jLabelCidade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jLabelCidade.setBounds(12, 110, 56, 22);
		getContentPane().add(jLabelCidade);
		textFieldCidade.setBounds(65, 111, 176, 22);
		getContentPane().add(textFieldCidade);
		
		jLabelSexo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jLabelSexo.setBounds(410, 10, 41, 22);
		getContentPane().add(jLabelSexo);
		comboBoxSexo.setBounds(463, 11, 96, 22);
		getContentPane().add(comboBoxSexo);
		
		jLabelNumeroDaCasa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jLabelNumeroDaCasa.setBounds(337, 74, 75, 22);
		getContentPane().add(jLabelNumeroDaCasa);
		textFieldNumeroDaCasa.setBounds(431, 75, 128, 22);
		getContentPane().add(textFieldNumeroDaCasa);
		jLabelDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jLabelDataDeNascimento.setBounds(253, 110, 133, 22);
		getContentPane().add(jLabelDataDeNascimento);
		textFieldDataDeNascimento.setBounds(395, 111, 164, 22);
		getContentPane().add(textFieldDataDeNascimento);
		jLabelContato.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jLabelContato.setBounds(308, 145, 75, 22);
		getContentPane().add(jLabelContato);
		textFieldContato.setBounds(395, 146, 164, 22);
		getContentPane().add(textFieldContato);
		jLabelEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jLabelEmail.setBounds(12, 75, 41, 22);
		getContentPane().add(jLabelEmail);
		textFieldEmail.setBounds(65, 71, 266, 22);
		getContentPane().add(textFieldEmail);
		jLabelRua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jLabelRua.setBounds(12, 145, 41, 22);
		getContentPane().add(jLabelRua);
		textFieldRua.setBounds(65, 145, 218, 22);
		getContentPane().add(textFieldRua);
		botaoConfirmar.setBounds(186, 201, 186, 25);
		botaoConfirmar.addActionListener(this);
		contentPane.add(botaoConfirmar);
		
		setSize(585, 286);
	}
	
	Aluno aluno = new Aluno("");
	
	
	public void actionPerformed(ActionEvent evento) {
		if(evento.getSource() == botaoConfirmar){
			Sistema.getGerenteAluno().removePessoa(num);
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
			aluno = new Aluno(nome);
			aluno.setMatricula(numeroIndetificacao);
			aluno.setEndereco(new Endereco(cidade, estado, rua, numeroDaCasa));
			aluno.getContato().setEmail(email);
			aluno.getContato().setTelefone(contato);
			aluno.setDataDeNascimento(dataDeNascimento);
			Sistema.getGerenteAluno().cadastrarAluno(aluno);
			setVisible(false);
			setLayout(null);
		}
	
		
	}
	public static void main(String[] args) {
		new Editar();
	}
}
