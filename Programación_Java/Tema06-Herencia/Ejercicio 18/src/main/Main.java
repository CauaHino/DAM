package main;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

import Autor.Autor;
import Libros.Libros;

public class Main {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		boolean salir = false;
		int opcion;
		Libros libro = null;
		Libros libros[] = new Libros[3];
		Libros estanteria[][] = new Libros[2][2];

		String titulo, isbn, editorial, nombreAutor, apellidosAutor, DNIAutor;
		int numPaginas, dia, mes, anio;
		LocalDate fechaNacimiento;
		Autor autor = null;

		while (!salir) {

			System.out.println("1. Crear un autor.");
			System.out.println("2. Insertar 3 libros.");
			System.out.println("3. Mostrar información del autor.");
			System.out.println("4. Eliminar libro.");
			System.out.println("5. Estanteria");
			System.out.println("6. Salir");
			System.out.println("Elige una opcion");
			opcion = entrada.nextInt();
			entrada.nextLine();

			switch (opcion) {
			case 1:

				System.out.println("Introduce el nombre del autor");
				nombreAutor = entrada.nextLine();

				System.out.println("Introduce los apellidos del autor");
				apellidosAutor = entrada.nextLine();

				System.out.println("Introduce el DNI del autor");
				DNIAutor = entrada.nextLine();

				System.out.println("Introduce el dia de la fecha de nacimiento");
				dia = entrada.nextInt();
				entrada.nextLine();

				System.out.println("Introduce el mes de la fecha de nacimiento");
				mes = entrada.nextInt();
				entrada.nextLine();

				System.out.println("Introduce el año de la fecha de nacimiento");
				anio = entrada.nextInt();
				entrada.nextLine();

				fechaNacimiento = LocalDate.of(anio, mes, dia);

				autor = new Autor(nombreAutor, apellidosAutor, fechaNacimiento, DNIAutor, libros);
				System.out.println("Autor creado");

				break;

			case 2:
				if (autor == null) {
					System.out.println("Debes crear un autor primero");
				} else {
					for (int i = 0; i < 3; i++) {
						System.out.println("Introduce el título del libro");
						titulo = entrada.nextLine();

						System.out.println("Introduce el ISBN del libro");
						isbn = entrada.nextLine();

						System.out.println("Introduce la editorial del libro");
						editorial = entrada.nextLine();

						System.out.println("Introduce el nº de páginas");
						numPaginas = entrada.nextInt();
						entrada.nextLine();

						libro = new Libros(titulo, isbn, editorial, numPaginas);
						if (autor != null) {
							autor.insertarLibro(libro);
						}

					}
					break;
				}

			case 3:
				System.out.println("La información del autor es: ");
				System.out.println(autor);
				break;

			case 4:
				System.out.println("Dame el título del libro a eliminiar");
				titulo = entrada.nextLine();
				if (autor != null) {
					autor.eliminarLibro(titulo);
				}
				break;
			case 5:
				int indiceLibro = 0;
				for (int i = 0; i < estanteria.length; i++) {
					for (int j = 0; j < estanteria[0].length; j++) {
						if (estanteria[i][j] == null && indiceLibro < autor.getNumLibros().length) {
							estanteria[i][j] = autor.getNumLibros()[indiceLibro];
							indiceLibro++;
						} else {
							estanteria[i][j] = null;
						}
					}
				}
				System.out.println("Información estanteria");
				for (int i = 0; i < estanteria.length; i++) {
					System.out.println();
					for (int j = 0; j < estanteria[0].length; j++) {
						System.out.println(estanteria[i][j]);
					}
				}
				System.out.println();
				break;
			case 6:
				salir = true;
				break;
			}

		}
	}
}
