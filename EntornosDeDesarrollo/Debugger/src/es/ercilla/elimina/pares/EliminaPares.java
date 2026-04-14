package es.ercilla.elimina.pares;

import java.util.ArrayList;

public class EliminaPares {
	public static void eliminarPares(ArrayList<Integer> numeros) {

		for (Integer i : numeros) {
			if (i % 2 == 0) {
				numeros.remove(i);
			}
		}

	}

	public static void main(String[] args) {
		ArrayList<Integer> numeros = new ArrayList<>();
		numeros.add(2);
		numeros.add(4);
		numeros.add(5);
		numeros.add(6);
		numeros.add(8);

		eliminarPares(numeros);

		System.out.println(numeros);
	}
}
