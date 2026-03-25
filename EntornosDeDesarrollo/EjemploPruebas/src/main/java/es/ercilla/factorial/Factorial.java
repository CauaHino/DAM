package es.ercilla.factorial;

public class Factorial {

	public static long factorial(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("El número debe ser mayor o igual a 0");
		}

		if (n == 0 || n == 1) {
			return 1;
		}

		return n * factorial(n - 1);
	}

}
