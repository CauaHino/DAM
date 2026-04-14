package es.ercilla.buscar.alumnos;

import java.util.ArrayList;

public class BuscaAlumno {
	public static boolean buscarAlumno(ArrayList<String> alumnos, String nombre) {
		boolean encontrado = false;

		for (String alumno : alumnos) {
			if (alumno.equals(nombre)) {
				encontrado = true;
			}
		}

		return encontrado;
	}

	public static void main(String[] args) {
		ArrayList<String> alumnos = new ArrayList<>();
		alumnos.add("Ana");
		alumnos.add("Luis");
		alumnos.add("Marta");

		System.out.println(buscarAlumno(alumnos, "Pepe"));
	}
}
