package es.ercilla.maximo.array.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import es.ercilla.maximo.array.MaximoArray;

public class MaximoArrayTest {
	@Test
	@DisplayName("Máximo en array estándar")
	void maximoArrayNormal() {
		int[] datos = { 4, 9, 2, 7 };
		int resultado = MaximoArray.obtenerMaximo(datos);
		assertEquals(9, resultado);
	}

	@Test
	@DisplayName("Máximo en array negativo")
	void maximoArrayNegativos() {
		int[] datos = { -5, -2, -9, -1 };
		int resultado = MaximoArray.obtenerMaximo(datos);
		assertEquals(-1, resultado);
	}

	@Test
	@DisplayName("El array no puede ser null ni vacío")
	void maximoArrayNull() {
		Executable accion = new Executable() {
			@Override
			public void execute() {
				MaximoArray.obtenerMaximo(null);
			}
		};
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, accion);
		assertTrue(ex.getMessage().toLowerCase().contains("el array no puede ser null ni vacío"));
	}
}
