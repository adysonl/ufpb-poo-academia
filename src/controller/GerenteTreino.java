package controller;
import java.util.ArrayList;
import java.util.Iterator;

import model.Treino;

public class GerenteTreino {
	
	private ArrayList<Treino> treinos = new ArrayList<Treino>(); 
	
	public void cadastrarTreino(Treino treino){
		treinos.add(treino);
	}
	
	public ArrayList<Treino> todosTreinos(){
		return treinos;
	}
	
	public Treino getTreino(int i){
		return treinos.get(i);
	}
}
