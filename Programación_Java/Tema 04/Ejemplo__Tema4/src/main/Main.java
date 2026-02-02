package main;

import punto.Punto;

public class Main {

	public static void main(String[] args) {
		Punto punto1 = new Punto(2, 2);
		
		int valorX = punto1.dameX();
		int valorY = punto1.dameY();
		
		System.out.println("Las coordenadas de X vale: " + valorX + " y de la Y vale: " + valorY);
		System.out.println();
		
		punto1.desplazar(3, 1);
		
		System.out.println("Las coordenadas desplazadas de X vale: "+ punto1.dameX()+ " y de la Y vale: "+ punto1.dameY());
		System.out.println();
		
		punto1.modificaX (8);
		punto1.modificaY(10);
		
		System.out.println("Las coordenadas modificada de X vale: "+ punto1.dameX()+ " y de la Y vale: "+ punto1.dameY());
	}

}
