package es.ercilla.fibonacci.recursivo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class FibonacciRecursivoTest {

	@Test
	@DisplayName("Error si el parámetro es menor que cero")
	void fibonacciMenor0() {
		Executable accion = new Executable() {
			@Override
			public void execute() {
				FibonacciRecursivo.fibonacci(-1);
			}
		};
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, accion);
		assertTrue(ex.getMessage().toLowerCase().contains("el parámetro introducido es negativo"));
	}

	@Test
	@DisplayName("Valida el número cero")
	void fibonacci0() {
		assertEquals(0, FibonacciRecursivo.fibonacci(0));
	}

	@Test
	@DisplayName("Valida el número uno")
	void fibonacci1() {
		assertEquals(1, FibonacciRecursivo.fibonacci(1));
	}

	@Test
	@DisplayName("Validamos casos conocidos, con números pequeños")
	void fibonacciPequenos() {
		assertEquals(1, FibonacciRecursivo.fibonacci(2));
		assertEquals(2, FibonacciRecursivo.fibonacci(3));
		assertEquals(3, FibonacciRecursivo.fibonacci(4));
		assertEquals(5, FibonacciRecursivo.fibonacci(5));
	}

	@Test
	@DisplayName("Validamos casos conocidos, con números medianos")
	void fibonacciMedios() {
		assertEquals(55, FibonacciRecursivo.fibonacci(10));
		assertEquals(610, FibonacciRecursivo.fibonacci(15));
		assertEquals(6765, FibonacciRecursivo.fibonacci(20));
	}

	@Test
	@DisplayName("Validamos casos conocidos, con números grandes")
	void fibonacciLimite() {
		assertEquals(832040, FibonacciRecursivo.fibonacci(30));
	}
}
