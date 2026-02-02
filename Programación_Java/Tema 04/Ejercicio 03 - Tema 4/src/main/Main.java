package main;

import mesa.Mesa;

public class Main {

	public static void main(String[] args) {

		Mesa mesa1 = new Mesa();
		System.out.println(mesa1);

		Mesa mesa2 = new Mesa(50, 90, 30, "BLANCO", "HIERRO");
		System.out.println(mesa2);

		Mesa mesa3 = new Mesa(60, 100, 40);
		System.out.println(mesa3);

		System.out.println("El color de la mesa 3 es: " + mesa3.dameColor());
		mesa3.modificarColor("ROJO");
		mesa3.mostrarColor();

	}

}
