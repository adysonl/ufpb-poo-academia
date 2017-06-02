package controller;

import java.util.ArrayList;

import model.Aluno;
import model.Professor;

public class GerenteDeProfessor {
	ArrayList<Professor> professores = new ArrayList<Professor>();
	
	public ArrayList<Professor> todosProfessores(){
		return professores;
	}
	public void cadastrarProfessor(Professor p){
		professores.add(p);
	}
	
	public int buscarIndexProfessor(String nome){
		for(int i = 0; i < professores.size(); i++){
			if(professores.get(i).getNome().equals(nome))
				return i;
		}
		return -1;
	}
	
	
	
	public String buscarProfessorI(int num){
		return professores.get(num).getNome();
	}
	
	public boolean ExisteProfessor(String nome){
		for(Professor p: professores){
			if(p.getNome().equals(nome))
				return true;
		}
		return false;
	}

	public Professor buscarProfessor(String nome) {
		for(Professor p: professores){
			if(p.getNome().equals(nome))
				return p;
		}
		return null;	
		}
	public void removePessoa(int index){
		professores.remove(index);
	}
}
