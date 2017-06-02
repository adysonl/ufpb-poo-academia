package model;

import java.util.Random;

public class Codigo {
	private Random gerador = new Random();
	private int[] numero = new int[5];

	Codigo() {
		for (int i = 0; i < 5; i++) {
			numero[i] = gerador.nextInt(10);
		}
	}

}
