package controller;

import java.util.ArrayList;

import model.Pessoa;

public abstract class Gerente {
	private ArrayList<Pessoa> lista = new ArrayList<Pessoa>();

	public void cadastrar(Pessoa p) {
		lista.add(p);
	}

	public ArrayList<Pessoa> getLista() {
		return lista;
	}

	public int buscarPosicao(String nome) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).equals(nome)) {
				return i;
			}
		}
		return -1;

	}

	public Pessoa buscar(String nome) {
		for (Pessoa p : lista) {
			if (p.getNome().equals(nome)) {
				return p;
			}
		}

		return null;
	}

	public boolean existe(String nome){
		for (Pessoa p : lista) {
			if (p.getNome().equals(nome)) {
				return true;
			}
		}
		return false;
	}

	public void remover(String nome){
		lista.remove(buscar(nome));
	}
}
