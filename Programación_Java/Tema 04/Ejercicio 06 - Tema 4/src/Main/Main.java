package Main;

import java.util.Scanner;

import Fracciones.Fraccion;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Fraccion fraccion1 = new Fraccion();

		System.out.println("Introduzca el númerador: ");
		double numerador = scan.nextDouble();
		
		System.out.println("Introduzca el denominador: ");
		double denominador = scan.nextDouble();
		
		fraccion1.asignarDatos(numerador, denominador);
		System.out.println("La fracción es: ");
		fraccion1.mostrarFraccion ();
		
		System.out.println("La solución real es: " + fraccion1.solucionReal());
		

	}

}
