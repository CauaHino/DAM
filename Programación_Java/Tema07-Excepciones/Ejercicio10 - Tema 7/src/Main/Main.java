package main;

import excepciones.CartaNoExiste;
import excepciones.CartaNoValida;
import mazo.Mazo;

public class Main {
	public static void main(String[] args) {
		Mazo mazo = new Mazo();
		
		mazo.mostrarCarta();
		
		try {
			if(mazo.jugar()) {
				System.out.println("Gano la jugada");
				System.out.println("Con: " + mazo.sumaTotal());
			}else {
				System.out.println("Perdio la jugada");
				System.out.println("Con: " + mazo.sumaTotal());
			}
		}catch(CartaNoExiste e) {
			e.printStackTrace();
		}catch(CartaNoValida e) {
			e.printStackTrace();
		}
	}
}
