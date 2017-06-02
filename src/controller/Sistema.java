package controller;

import view.Janela;

public class Sistema {
	private static GerenteDeAluno gerenteAluno = new GerenteDeAluno();
	private static GerenteTreino gerenteTreino = new GerenteTreino();
	private static GerenteExercicio gerenteExercicio = new GerenteExercicio();
	private static GerenteDeProfessor gerenteProfessor = new GerenteDeProfessor();
	
	private static Janela janela = new Janela();
	
	public static void main(String[] args) {
	
	}

	public static GerenteDeAluno getGerenteAluno() {
		return gerenteAluno;
	}

	public static GerenteTreino getGerenteTreino() {
		return gerenteTreino;
	}

	public static GerenteExercicio getGerenteExercicio() {
		return gerenteExercicio;
	}

	public static GerenteDeProfessor getGerenteProfessor() {
		return gerenteProfessor;
	}

	public static Janela getJanela() {
		return janela;
	}
	
	
}
