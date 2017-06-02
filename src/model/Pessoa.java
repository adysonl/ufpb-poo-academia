package model;

public class Pessoa {
	
	private String nome;
	private String dataDeNascimento;
	private Endereco endereco;
	private Contato contato = new Contato();
	private SexoType sexo;
	
	Pessoa(String nome){
		this.setNome(nome);
		//this.sexo = SexoType.valueOf(sexo);
	}
		
	public SexoType getSexo() {
		return sexo;
	}

	public void setSexo(SexoType sexo) {
		this.sexo = sexo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
}
