package Main;

import Puntos.Punto;

public class Main {

	public static void main(String[] args) {

		Punto punto1 = new Punto();

		int valorX = punto1.dameX();
		int valorY = punto1.dameY();

		System.out.println("Punto 1: " + "\n" + punto1);

		Punto punto2 = new Punto(2, 4);
		System.out.println("Punto 2: " + "\n" + punto2);

		punto1.desplazar(2,2);
		punto2.desplazar(28);
		System.out.println("DESPLAZADAS: " + "\n"+"Punto 1: "+"\n" + punto1 + "\n"+ "Punto 2: "+"\n" +punto2);

	}

}
