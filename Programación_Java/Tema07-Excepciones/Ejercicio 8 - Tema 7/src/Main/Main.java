package Main;

import Excepciones.PosicionFueraDelTablero;
import fichas.Ficha;
import fichas.Rey;
import fichas.Torre;

public class Main {

	public static void main(String[] args) {
		Ficha[] fichas = new Ficha[3];
		
		fichas[0] = new Torre("Blanco", 2,3);
		fichas[1] = new Rey("Negro", 3,6);
		try {
			fichas[1].movimientoValido(0, 9);
		} catch(PosicionFueraDelTablero e) {
			System.err.println(e.toString());
		}
		
	}

}
