package controller;
import model.Aluno;
import view.Janela;

import java.util.ArrayList;

public class GerenteDeAluno {
	ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	
	public void cadastrarAluno(Aluno aluno){
		alunos.add(aluno);
	}
	
	public ArrayList<Aluno> todosAlunos(){
		return alunos;
	}
	
	public int buscarIndexAluno(String nome){
		for(int i = 0; i < alunos.size(); i++){
			if(alunos.get(i).getNome().equals(nome))
				return i;
		}
		return -1;
	}
	public Aluno buscarAluno(String nome){
		for(Aluno aluno: alunos){
			if(aluno.getNome().equals(nome))
				return aluno;
		}
		return null;
	}

	public boolean ExisteAluno(String nome){
		for(Aluno aluno: alunos){
			if(aluno.getNome().equals(nome))
				return true;
		}
		return false;
	}
	
	
	
	public void removePessoa(int index){
		alunos.remove(index);
	}
	
	
}
