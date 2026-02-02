package Excepciones;

public class AgendaLlena extends Exception {
	public String toString() {
		return "La agenda está llena, no es posible añadir más contactos";
	}

}
