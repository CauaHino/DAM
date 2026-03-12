package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import persona.Persona;

public class Main {

	public static void main(String[] args) {
		Scanner see = new Scanner(System.in);
		List<Persona> listaPersona = new ArrayList<Persona>();
		boolean salir = true;
		int opcion;

		System.out.println("Bienvenido al creado de personas");

		while (salir) {
			System.out.println("=== MENU ===");
			System.out.println("1. Crear una persona");
			System.out.println("2. Mostrar la lista de personas");
			System.out.println("3. Media de edad de las personas");
			System.out.println("4. Cantidad de personas con el genero masculino");
			System.out.println("5. Cantidad de personas con el genero femenino");
			System.out.println("6. Salir");

			System.out.print("Elija una opcion: ");
			opcion = see.nextInt();
			see.nextLine();

			switch (opcion) {
			case 1:
				System.out.print("Cuantas personas quieres crear: ");
				int cantidadPersonas = see.nextInt();
				see.nextLine();

				for (int i = 0; i < cantidadPersonas; i++) {
					System.out.println("=== PERSONA " + (i + 1) + "===");
					System.out.print("Indique el nombre: ");
					String nombre = see.nextLine();

					System.out.print("Indique los apellidos: ");
					String apellidos = see.nextLine();

					System.out.print("Indique el genero (M/F): ");
					String genero = see.nextLine();
					boolean generoB;
					if (genero.equalsIgnoreCase("m")) {
						generoB = true;
					} else if (genero.equalsIgnoreCase("f")) {
						generoB = false;
					} else {
						System.out.println("Ese genero no existe");
						continue;
					}

					System.out.print("Indique la edad: ");
					int edad = see.nextInt();
					see.nextLine();

					listaPersona.add(new Persona(nombre, apellidos, generoB, edad));
				}
				break;
			case 2:
				mostrarPersonas(listaPersona);
				break;
			case 3:
				mostrarPromedioEdades(listaPersona);
				break;
			case 4:
				mostrarMasculino(listaPersona);
				break;
			case 5:
				mostrarFemenino(listaPersona);
				break;
			case 6:
				salir = false;
				break;
			default:
				System.out.println("Elija la opcion correcta");
			}
		}

	}

	public static void mostrarPersonas(List<Persona> personas) {
		for(Persona p : personas) {
			System.out.println("Persona\n" +
								"\tNombre: " + p.getNombre() + "\n" +
								"\tGenero: " + (p.isGenero() ? "Masculino" : "Femenino"));
		}
	}
	
	public static void mostrarPromedioEdades(List<Persona> personas) {
		double sumaEdades = 0;
		
		for(Persona p : personas) {
			sumaEdades += p.getEdad();
		}
		
		System.out.println("La media de edad de las personas es: " + sumaEdades / personas.size());
	}
	
	public static void mostrarMasculino(List<Persona> personas) {
		int masculino = 0;
		
		for(Persona p : personas) {
			if(p.isGenero() == true) {
				masculino++;
			}
		}
		
		System.out.println("La cantidad de hombres en las lista es: " + masculino);
	}
	
	public static void mostrarFemenino(List<Persona> personas) {
		int femenino = 0;

		for (Persona p : personas) {
			if (p.isGenero() == true) {
				femenino++;
			}
		}

		System.out.println("La cantidad de hombres en las lista es: " + femenino);
	}
}
