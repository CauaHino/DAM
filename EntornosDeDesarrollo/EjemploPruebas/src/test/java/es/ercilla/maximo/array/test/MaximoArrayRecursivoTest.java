package es.ercilla.maximo.array.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import es.ercilla.maximo.array.MaximoArrayRecursivo;

public class MaximoArrayRecursivoTest {
	@Test
	@DisplayName("Array estándar")
	void testArrayNormal() {
		int[] array = { 3, 7, 2, 9, 5 };
		assertEquals(9, MaximoArrayRecursivo.maximo(array));
	}

	@Test
	@DisplayName("Array con negativos")
	void testArrayNegativos() {
		int[] array = { -10, -3, -50, -1 };
		assertEquals(-1, MaximoArrayRecursivo.maximo(array));
	}

	@Test
	@DisplayName("Array único elemento")
	void testArrayUnElemento() {
		int[] array = { 8 };
		assertEquals(8, MaximoArrayRecursivo.maximo(array));
	}

	@Test
	@DisplayName("Array ordenado")
	void testArrayOrdenado() {
		int[] array = { 1, 2, 3, 4, 5 };
		assertEquals(5, MaximoArrayRecursivo.maximo(array));
	}

	@Test
	@DisplayName("Array vacío")
	void testArrayVacio() {
		int[] array = {};
		Executable accion = new Executable() {
			@Override
			public void execute() {
				MaximoArrayRecursivo.maximo(array);
			}
		};
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, accion);
		assertTrue(ex.getMessage().toLowerCase().contains("el array no puede ser nulo o vacío"));
	}
}
