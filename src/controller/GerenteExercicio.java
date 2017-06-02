package controller;

import java.util.ArrayList;

import model.Exercicio;

public class GerenteExercicio {

	private ArrayList<Exercicio> exercicios = new ArrayList<Exercicio>();

	public void cadastrarExercicio(Exercicio exercicio) {
		exercicios.add(exercicio);
	}
	
	public ArrayList<Exercicio> todosExercicios(){
		return exercicios;
	}
	

}
