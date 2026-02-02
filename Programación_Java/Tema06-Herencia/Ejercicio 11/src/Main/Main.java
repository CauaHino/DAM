package Main;

import Alumno.Alumno;
import Aula.Aula;
import Instituto.Instituto;

public class Main {
	public static void main(String[] args) {
		// --- 1. Crear 20 alumnos ---
		/*
		 * System.out.println("--- Creación de 20 Alumnos ---"); Alumno[] listaAlumnos =
		 * new Alumno[20];
		 * 
		 * // Nombres y apellidos de ejemplo String[] nombres = { "Ana", "Berto",
		 * "Carlos", "Diana", "Elena", "Fran", "Gema", "Hugo", "Irene", "Javier",
		 * "Karla", "Luis", "Marta", "Nacho", "Olga", "Pablo", "Quim", "Rosa", "Sergio",
		 * "Tania" }; String[] apellidos = { "García", "López", "Martínez", "Ruiz",
		 * "Hernández", "Díaz", "Pérez", "Sánchez", "Romero", "Torres", "Álvarez",
		 * "Gómez", "Jiménez", "Moreno", "Muñoz", "Vázquez", "Navarro", "Gil", "Ramos",
		 * "Sanz" };
		 * 
		 * for (int i = 0; i < 20; i++) { listaAlumnos[i] = new Alumno(nombres[i],
		 * apellidos[(i + 5) % 20], // Mezcla de apellidos para que no // coincidan
		 * (10000000 + i) + "Z", 18 + (i % 3) // Edades entre 18 y 20 ); }
		 * 
		 * System.out.println("\n--- Creación de Aulas de 15 Alumnos ---"); Aula aula1 =
		 * new Aula(15); Aula aula2 = new Aula(15);
		 * 
		 * for (int i = 0; i < 10; i++) { aula1.entraAlumno(listaAlumnos[i]); }
		 * 
		 * for (int i = 10; i < 20; i++) {
		 * 
		 * aula2.entraAlumno(listaAlumnos[i]); }
		 * 
		 * aula1.mostrarAlumnos(); aula2.mostrarAlumnos();
		 * 
		 * System.out.println("\n--- Pruebas de Funcionalidad de Aula ---");
		 * 
		 * System.out.println("Alumnos actuales en Aula 1: " + aula1.numeroAlumnos());
		 * // 10
		 * 
		 * for (int i = 15; i < 20; i++) { if (i < 15) { aula1.entraAlumno(new
		 * Alumno(nombres[i], apellidos[i], "DNI-TEMP", 19)); } }
		 * 
		 * aula1.entraAlumno(new Alumno("Extra", "Lleno", "DNI-LLENO", 20));
		 * System.out.println("Alumnos actuales en Aula 1: " + aula1.numeroAlumnos());
		 * 
		 * aula1.saleAlumno("Ana");
		 * System.out.println("Alumnos actuales en Aula 1 después de sacar a 'Ana': " +
		 * aula1.numeroAlumnos()); // 14 aula1.mostrarAlumnos();
		 * 
		 * aula1.ordenarAlumnos(); aula1.mostrarAlumnos();
		 * 
		 * Instituto miInstituto = new Instituto(20);
		 * 
		 * System.out.println("\nAula ID " +
		 * miInstituto.dameAulas()[0].dameIdentificador() +
		 * " (primera de 35): Capacidad " + miInstituto.dameAulas()[0].numeroAlumnos());
		 * System.out.println("Aula ID " +
		 * miInstituto.dameAulas()[10].dameIdentificador() +
		 * " (primera de 25): Capacidad " +
		 * miInstituto.dameAulas()[10].numeroAlumnos()); System.out.println("Aula ID " +
		 * miInstituto.dameAulas()[15].dameIdentificador() +
		 * " (primera de 15): Capacidad " +
		 * miInstituto.dameAulas()[15].numeroAlumnos()); }
		 */
		Instituto instituto = new Instituto(2);

		Aula aula01 = instituto.dameAulas()[0] = new Aula(3, 3);
		Aula aula02 = instituto.dameAulas()[1] = new Aula(3, 3);

		Alumno alumnosAula01[][] = aula01.getAlumnosMatriz();

		System.out.println("Alumnos del AULA 01");

		for (int i = 0; i < alumnosAula01.length; i++) {
			for (int j = 0; j < alumnosAula01[0].length; j++) {
				alumnosAula01[i][j] = new Alumno("Pepe", "López", "12345678L", 20);
			}
		}
		Alumno alumnosAula02[][] = aula02.getAlumnosMatriz();

		System.out.println("Alumnos del AULA 02");

		for (int i = alumnosAula02.length - 1; i >= 0; i--) {
			for (int j = alumnosAula02.length - 1; j >= 0; j--) {
				alumnosAula02[i][j] = new Alumno("Ana", "Gómez", "12345678L", 18);
			}
		}
		for (int i = 0; i < alumnosAula02.length; i++) {
			for (int j = 0; j < alumnosAula02[0].length; j++) {
				System.out.println(alumnosAula02[i][j]);
			}
		}
		for (int i = 0; i < instituto.dameAulas().length; i++) {
			for (int j = 0; j < alumnosAula01.length; j++) {
				System.out.print("| ");
				for (int k = 0; k < alumnosAula02[0].length; k++) {
					System.out.print(instituto.dameAulas()[i].getAlumnosMatriz()[j][k].getIdentificador() + " |");
				}
				System.out.println();
			}
			System.out.println();
		}
		for (int i = 0; i < instituto.dameAulas().length; i++) {
			for (int j = 0; j < alumnosAula01.length; j++) {
				for (int k = 0; k < alumnosAula02[0].length; k++) {
					if (instituto.dameAulas()[i].getAlumnosMatriz()[j][k].getIdentificador() == 15) {
						aula02.getAlumnosMatriz()[j][k].modificaNombre("Caua");
					}
				}
			}
		}
		for (int i = 0; i < instituto.dameAulas().length; i++) {
			for (int j = 0; j < alumnosAula01.length; j++) {
				System.out.print("| ");
				for (int k = 0; k < alumnosAula02[0].length; k++) {
					System.out.print(instituto.dameAulas()[i].getAlumnosMatriz()[j][k].dameNombre() + " |");
				}
				System.out.println();
			}
			System.out.println();
		}
		// Cambio del alumno ID = 2 por el alumno con ID = 12;
		Alumno alumnoExtraido01 = null;
		Alumno alumnoExtraido02 = null;

		for (int i = 0; i < instituto.dameAulas().length; i++) {
			for (int j = 0; j < alumnosAula01.length; j++) {
				for (int k = 0; k < alumnosAula02[0].length; k++) {
					if (instituto.dameAulas()[i].getAlumnosMatriz()[j][k].getIdentificador() == 2) {
						alumnoExtraido01 = aula01.getAlumnosMatriz()[j][k];
					}
				}
			}
		}
		for (int i = 0; i < instituto.dameAulas().length; i++) {
			for (int j = 0; j < alumnosAula01.length; j++) {
				for (int k = 0; k < alumnosAula02[0].length; k++) {
					if (instituto.dameAulas()[i].getAlumnosMatriz()[j][k].getIdentificador() == 12) {
						alumnoExtraido02 = aula02.getAlumnosMatriz()[j][k];

					}
				}
			}
		}
		for (int i = 0; i < instituto.dameAulas().length; i++) {
			for (int j = 0; j < alumnosAula01.length; j++) {
				for (int k = 0; k < alumnosAula02[0].length; k++) {
					if (instituto.dameAulas()[i].getAlumnosMatriz()[j][k].getIdentificador() == 2
							|| instituto.dameAulas()[i].getAlumnosMatriz()[j][k].getIdentificador() == 12) {
						aula01.getAlumnosMatriz()[j][k] = alumnoExtraido02;
						aula02.getAlumnosMatriz()[j][k] = alumnoExtraido01;

					}
				}
			}
		}
	}
}
