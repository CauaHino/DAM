package es.ercilla.palindromo;

public class PalindromoRecursivo {
	public static boolean esPalindromo(String texto) {

		if (texto == null) {
			throw new IllegalArgumentException("El texto no puede ser nulo");
		}

		texto = texto.replaceAll("\\s+", "").toLowerCase();

		return comprobar(texto, 0, texto.length() - 1);
	}

	private static boolean comprobar(String texto, int inicio, int fin) {

		// Caso base
		if (inicio >= fin) {
			return true;
		}

		// Si los caracteres no coinciden
		if (texto.charAt(inicio) != texto.charAt(fin)) {
			return false;
		}

		// Llamada recursiva
		return comprobar(texto, inicio + 1, fin - 1);
	}
}
