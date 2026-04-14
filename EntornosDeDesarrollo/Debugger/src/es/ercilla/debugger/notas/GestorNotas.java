package es.ercilla.debugger.notas;

import java.util.ArrayList;

public class GestorNotas {

	public static double calcularMedia(ArrayList<Integer> notas) {
		int suma = 0;

		for (int i = 0; i < notas.size(); i++) {
			suma += notas.get(i);
		}

		return suma / notas.size();
	}

	public static int obtenerMaximo(ArrayList<Integer> notas) {
		int max = 0;

		for (int i = 0; i < notas.size(); i++) {
			if (notas.get(i) > max) {
				max = notas.get(i);
			}
		}

		return max;
	}

	public static void main(String[] args) {
		ArrayList<Integer> notas = new ArrayList<Integer>();
		notas.add(10);
		notas.add(5);
		notas.add(15);

		System.out.println("Media: " + calcularMedia(notas));
		System.out.println("Máximo: " + obtenerMaximo(notas));
	}
}
