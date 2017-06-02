package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ficha extends JInternalFrame {
	

	JLabel lblFicha = new JLabel("Ficha");
	JLabel JLabelNumerodeIndentificacao = new JLabel("N\u00BA de Indentificacao");
	JLabel jLabelNome = new JLabel("Nome");
	JLabel jLabelEstado = new JLabel("Estado");
	JLabel jLabelCidade = new JLabel("Cidade");
	JLabel jLabelNumeroDaCasa = new JLabel("N\u00BA da Casa");
	JLabel jLabelDataDeNascimento = new JLabel("Data de Nascimento");
	JLabel jLabelContato = new JLabel("Telefone");
	JLabel jLabelRua = new JLabel("Rua");
	JLabel jLabelEmail = new JLabel("Email");
	JButton butaoCancelarAluno = new JButton("Cancelar");
	JButton butaoAdicionarAluno = new JButton("Adicionar");
	
	
	JLabel LabelNumeroDeIndetificacao = new JLabel("");
	JLabel labelNome = new JLabel("");
	JLabel LabelEstado = new JLabel("");
	JLabel labelDataDeNascimento = new JLabel("");
	JLabel labelRua = new JLabel("");
	JLabel labelTelefone = new JLabel("");
	JLabel LabelNumeroDaCasa = new JLabel("");
	JLabel LabelEmail = new JLabel("");
	JLabel labelCidade = new JLabel("");
	private final JButton btnNewButton = new JButton("Sair");
	
	public Ficha() {
		setIconifiable(true);
		setBounds(64, 36, 657, 298);

		JLabelNumerodeIndentificacao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabelNumerodeIndentificacao.setBounds(12, 80, 133, 16);
		getContentPane().add(JLabelNumerodeIndentificacao);
		
		jLabelNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jLabelNome.setBounds(12, 109, 63, 16);
		getContentPane().add(jLabelNome);
		
		jLabelEstado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jLabelEstado.setBounds(12, 138, 56, 22);
		getContentPane().add(jLabelEstado);
		
		jLabelCidade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jLabelCidade.setBounds(299, 77, 56, 22);
		getContentPane().add(jLabelCidade);
		
		jLabelNumeroDaCasa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jLabelNumeroDaCasa.setBounds(12, 173, 75, 22);
		getContentPane().add(jLabelNumeroDaCasa);
		
		jLabelDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jLabelDataDeNascimento.setBounds(299, 106, 133, 22);
		getContentPane().add(jLabelDataDeNascimento);
		
		jLabelContato.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jLabelContato.setBounds(297, 173, 87, 22);
		getContentPane().add(jLabelContato);
		
		jLabelEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jLabelEmail.setBounds(12, 217, 41, 22);
		getContentPane().add(jLabelEmail);
		
		jLabelRua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jLabelRua.setBounds(299, 138, 41, 22);
		getContentPane().add(jLabelRua);
		
		lblFicha.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 26));
		lblFicha.setBounds(12, 13, 88, 48);
		getContentPane().add(lblFicha);
		
		getContentPane().setLayout(null);
		LabelNumeroDeIndetificacao.setBounds(157, 81, 121, 16);
		
		getContentPane().add(LabelNumeroDeIndetificacao);
		labelNome.setBounds(63, 110, 201, 16);
		
		getContentPane().add(labelNome);
		LabelEstado.setBounds(63, 142, 215, 16);
		
		getContentPane().add(LabelEstado);
		
		
		LabelNumeroDaCasa.setBounds(99, 177, 165, 16);
		getContentPane().add(LabelNumeroDaCasa);
		
		
		LabelEmail.setBounds(59, 221, 219, 16);
		getContentPane().add(LabelEmail);
		
		
		labelCidade.setBounds(356, 81, 254, 16);
		getContentPane().add(labelCidade);
		labelDataDeNascimento.setBounds(444, 110, 166, 16);
		
		getContentPane().add(labelDataDeNascimento);
		labelRua.setBounds(340, 142, 270, 16);
		
		getContentPane().add(labelRua);
		labelTelefone.setBounds(368, 179, 242, 16);
		
		getContentPane().add(labelTelefone);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(299, 217, 97, 25);
		
		getContentPane().add(btnNewButton);
		setVisible(false);

	}
	public static void main(String[] args) {
		new Ficha();
	}
}
