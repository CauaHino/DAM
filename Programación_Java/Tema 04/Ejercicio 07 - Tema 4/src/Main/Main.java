package Main;

import Bombilla.Bombilla;

public class Main {

	public static void main(String[] args) {
		
		Bombilla bombilla1 = new Bombilla();
		System.out.println("BOMBILLA 1:");
		Bombilla.activaGeneral();
		System.out.println("La bombilla está "+ bombilla1.encendida());
		
		Bombilla bombilla2 = new Bombilla();
		System.out.println("BOMBILLA 2:");
		bombilla2.enciende();
		System.out.println("La bombilla está "+ bombilla2.encendida());
		
		Bombilla bombilla3= new Bombilla();
		System.out.println("BOMBILLA 3:");
		Bombilla.activaGeneral();
		bombilla3.enciende();
		System.out.println("La bombilla está "+ bombilla3.encendida());
		
		Bombilla bombilla4= new Bombilla();
		System.out.println("BOMBILLA 4:");
		Bombilla.activaGeneral();
		bombilla4.enciende();
		System.out.println("La bombilla está "+ bombilla4.encendida());
		Bombilla.desactivaGeneral();
		System.out.println("La bombilla está "+ bombilla4.encendida());
	}

}
