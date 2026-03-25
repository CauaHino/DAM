package es.ercilla.maximo.array;

public class MaximoArray {
	public static int obtenerMaximo(int[] datos) {

		if (datos == null || datos.length == 0) {
			throw new IllegalArgumentException("El array no puede ser null ni vacío");
		}

		int max = datos[0];

		for (int i = 1; i < datos.length; i++) {
			if (datos[i] > max) {
				max = datos[i];
			}
		}

		return max;
	}
}
