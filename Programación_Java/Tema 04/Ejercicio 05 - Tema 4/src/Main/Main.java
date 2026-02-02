package Main;

import Rectangulo.Rectangulo;
import punto.Punto;

public class Main {

	public static void main(String[] args) {
		Rectangulo rec1 = new Rectangulo(8,4);
		rec1.mostrarCoordenadas();
		
		rec1.desplazar(-5,+2);
		System.out.println("DESPLAZADAS: ");
		rec1.mostrarCoordenadas();
		
		Punto p1 = new Punto(1,1);
		Punto p2 = new Punto(5,1);
		Punto p3 = new Punto(5,3);
		Punto p4 = new Punto(1,3);
		
		Rectangulo rec2 = new Rectangulo (p1,p2,p3,p4);
		rec2.mostrarCoordenadas();	
		

	}

}
