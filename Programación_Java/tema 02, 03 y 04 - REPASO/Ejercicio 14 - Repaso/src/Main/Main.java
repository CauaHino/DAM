package Main;

import java.time.LocalDate;
import java.util.Scanner;

import Persona.Persona;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int opciones;
		boolean salir = false;
		Persona p = null;

		String nombre, apellidos, dni;
		int dia, mes, ano;
		LocalDate fecha;
		Persona[] num = new Persona[5];
		int numPersonas = 0;

		while (!salir) {
			System.out.println("Seleccione una opción: ");
			System.out.println("1. Crear Persona");
			System.out.println("2. Ver Persona");
			System.out.println("3. Ver Edad");
			System.out.println("4. Ver DNI de la persona");
			System.out.println("5. Ver identificador de la persona");
			System.out.println("6. Salir");
			opciones = sc.nextInt();
			sc.nextLine();

			switch (opciones) {
			case 1:
				System.out.println("Introduce un nombre");
				nombre = sc.nextLine();

				System.out.println("Introduce los apellidos");
				apellidos = sc.nextLine();

				System.out.println("Introduce el DNI");
				dni = sc.nextLine();

				System.out.println("Introduce el dia");
				dia = sc.nextInt();
				System.out.println("Introduce el mes");
				mes = sc.nextInt();
				System.out.println("Introduce el año");
				ano = sc.nextInt();
				sc.nextLine();

				fecha = LocalDate.of(ano, mes, dia);

				p = new Persona(nombre, apellidos, fecha, dni);

				num[numPersonas] = p;
				numPersonas++;

				System.out.println("Persona creada y guardada con éxito!");
				break;

			case 2:
				System.out.println("--- Ver Persona ---");

				if (numPersonas == 0) {
					System.out.println("No hay personas registradas para mostrar.");
					break;
				}

				System.out.println("Personas registradas:");
				for (int i = 0; i < numPersonas; i++) {

					System.out.println((i + 1) + ". " + num[i].getName());
				}

				System.out.println("Introduce el número de la persona que deseas ver (o 0 para cancelar):");

				int seleccion = sc.nextInt();
				sc.nextLine();

				if (seleccion == 0) {
					System.out.println("Visualización cancelada.");
				} else if (seleccion >= 1 && seleccion <= numPersonas) {

					int indicePersona = seleccion - 1;

					Persona personaSeleccionada = num[indicePersona];

					System.out.println("\n--- Detalles de la Persona #" + seleccion + " ---");

					System.out.println(personaSeleccionada);

					System.out.println("------------------------------------------");
				} else {
					System.out.println("Número de persona no válido.");
				}
				break;
			case 3:
				if (numPersonas == 0) {
					System.out.println("Debes crear una persona primero");
				} else {
					System.out.println(p.getName() + " tiene " + p.getAnos() + " años");
				}
			case 4:
				if (numPersonas == 0) {
					System.out.println("Debes crear una persona primero");
				} else {
					System.out.println("El DNI de " + p.getName() + " es " + p.getdni());
				}
				break;
			case 5:
				if (numPersonas == 0) {
					System.out.println("Debes crear una persona primero");
				} else {
					System.out.println(p.getId());
				}
				break;
			case 6:
				salir = true;
				break;

			}

		}

	}

}
