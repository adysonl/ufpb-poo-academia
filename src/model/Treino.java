package model;

import java.util.ArrayList;

public class Treino {
	private String nome;
	private String descricao;
	private ArrayList<Exercicio> exercicios = new ArrayList<Exercicio>();

	public ArrayList<Exercicio> getExercicios() {
		return exercicios;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setExercicio(String nome, int serie, String grupoMuscular) {
		Exercicio exercicio = new Exercicio();
		exercicio.setNome(nome);
		exercicio.setSerie(serie);
		exercicio.setGrupoMuscular(grupoMuscular);
		exercicios.add(exercicio);
	}
}
