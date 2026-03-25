package es.ercilla.palindromo.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import es.ercilla.palindromo.PalindromoRecursivo;

public class PalindromoRecursivoTest {
	@Test
	void testPalindromoSimple() {
		assertTrue(PalindromoRecursivo.esPalindromo("reconocer"));
	}

	@Test
	void testPalindromoMayusculas() {
		assertTrue(PalindromoRecursivo.esPalindromo("Ana"));
	}

	@Test
	void testPalindromoConEspacios() {
		assertTrue(PalindromoRecursivo.esPalindromo("anita lava la tina"));
	}

	@Test
	void testNoPalindromo() {
		assertFalse(PalindromoRecursivo.esPalindromo("java"));
	}

	@Test
	void testTextoVacio() {
		assertTrue(PalindromoRecursivo.esPalindromo(""));
	}

	@Test
	void testTextoNulo() {
		Executable accion = new Executable() {
			@Override
			public void execute() {
				PalindromoRecursivo.esPalindromo(null);
			}
		};
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, accion);
		assertTrue(ex.getMessage().toLowerCase().contains("el texto no puede ser nulo"));
	}
}
