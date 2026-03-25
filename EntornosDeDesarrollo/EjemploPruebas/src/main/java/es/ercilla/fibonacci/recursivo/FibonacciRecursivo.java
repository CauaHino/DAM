package es.ercilla.fibonacci.recursivo;

/**
 * Clase que contiene un único método para realizar el cálculo del n-ésimo
 * Fibonacci
 */
public class FibonacciRecursivo {
	/**
	 * Método que calcula el n-ésimo por Fibonacci f(x)=(x-1)+(x-2)
	 * 
	 * @param n n-ésimo elemento para calcular su valor en la serie Fibonacci
	 * @return el valor de fibonacci para el n-ésimo
	 * @throws IllegalArgumentException si el parámetro introducido es negativo
	 */
	public static long fibonacci(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("El parámetro introducido es negativo, debe ser mayor o igual a cero");
		} else if (n == 0) {
			return n;
		} else if (n == 1) {
			return n;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

}