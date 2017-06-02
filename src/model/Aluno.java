package model;

public class Aluno extends Pessoa {
	
	private boolean ativo;
	private String matricula;
	private Treino treino = new Treino();
	
	
	public Aluno(String nome) {
		super(nome);
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Treino getTreino() {
		return treino;
	}

	public void setTreino(Treino treino) {
		this.treino = treino;
	}

}
