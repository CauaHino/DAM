package es.ercilla.par;

/**
 * Clase que contiene un único método que determina si un número es par o no
 */
public class NumeroPar {

	/**
	 * Método que identifica si un número es par
	 * 
	 * @param numero a identificar como par o no
	 * @return true si es par, false si es impar
	 */
	public static boolean esPar(int numero) {
		return numero % 2 == 0;
	}

	/**
	 * Constructor por defecto
	 */
	public NumeroPar() {
		super();
	}

}
