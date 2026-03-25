package es.ercilla.factorial.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import es.ercilla.factorial.Factorial;

public class FactorialTest {

	@Test
	@DisplayName("Caso base 0")
	void factorial0() {
		assertEquals(1, Factorial.factorial(0));
	}

	@Test
	@DisplayName("Caso base 1")
	void factorial1() {
		assertEquals(1, Factorial.factorial(1));
	}

	@Test
	@DisplayName("Caso normal con 3")
	void factorial3() {
		assertEquals(6, Factorial.factorial(3));
	}

	@Test
	@DisplayName("Caso normal con 5")
	void factorial5() {
		assertEquals(120, Factorial.factorial(5));
	}

	@Test
	@DisplayName("Error si el parámetro es menor que cero")
	void factorialMenor0() {
		Executable accion = new Executable() {
			@Override
			public void execute() {
				Factorial.factorial(-1);
			}
		};
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, accion);
		assertTrue(ex.getMessage().toLowerCase().contains("debe ser mayor o igual a 0"));
	}

}
