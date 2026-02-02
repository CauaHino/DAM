package Main;

import java.util.Scanner;

import Perro.Perro;
import Persona.Persona;

public class Main {

	public static void main(String[] args) {
		Perro perro1 = new Perro("Pastor Alemán", "Paco", "Marrón", 0.5);

		String nombre = perro1.dameNombre();

		System.out.println(perro1);

		Perro perro2 = new Perro("Bulldog", "Di María", "Negro", 1);

		double edad2 = perro2.dameEdad();

		System.out.println(perro2);

		Perro perro3 = new Perro("Golden", "Cucurella", "Amarillo", 2);

		String color3 = perro3.dameColor();
		System.out.println(perro3);

		System.out.println("ACCIONES PERROS: ");
		perro1.ladrar();
		perro2.caminar();
		perro3.sleep();

		System.out.println("Los perros modificados: ");

		perro1.modificaColor("Azul");
		System.out.println(perro1);

		perro2.modificaEdad(5);
		System.out.println(perro2);

		perro3.modificaNombre("Messi");
		System.out.println(perro3);

		System.out.println("El nombre del perro 1 es: " + nombre);
		System.out.println("La edad del perro 2 es: " + edad2);
		System.out.println("El color del perro 3 es: " + color3);

		Scanner datosEntrada = new Scanner(System.in);

		System.out.println("Introduzca el Nombre");
		String nombre1 = datosEntrada.nextLine();

		System.out.println("Introduzca el DNI");
		String dni1 = datosEntrada.nextLine();

		System.out.println("Introduzca la Edad");
		int edad1 = datosEntrada.nextInt();

		Persona persona1 = new Persona(nombre1, dni1, edad1, perro3);
		System.out.println(persona1);

		Persona persona2 = new Persona();
		persona2.modificaMascota(perro1);
		System.out.println(persona2);

	}

}
