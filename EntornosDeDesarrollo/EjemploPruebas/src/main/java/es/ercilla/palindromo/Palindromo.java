package es.ercilla.palindromo;

public class Palindromo {

	public static boolean esPalindromo(String texto) {

		if (texto == null) {
			return false;
		}

		String invertido = new StringBuilder(texto).reverse().toString();

		return texto.equalsIgnoreCase(invertido);
	}
}
