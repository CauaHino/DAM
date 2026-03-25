package es.ercilla.maximo.array;

public class MaximoArrayRecursivo {
	public static int maximo(int[] array) {

		if (array == null || array.length == 0) {
			throw new IllegalArgumentException("El array no puede ser nulo o vacío");
		}

		return maximoRec(array, array.length - 1);
	}

	private static int maximoRec(int[] array, int indice) {

		// Caso base
		if (indice == 0) {
			return array[0];
		}

		// Llamada recursiva
		int maxAnterior = maximoRec(array, indice - 1);

		// Comparación
		if (array[indice] > maxAnterior) {
			return array[indice];
		} else {
			return maxAnterior;
		}
	}
}
