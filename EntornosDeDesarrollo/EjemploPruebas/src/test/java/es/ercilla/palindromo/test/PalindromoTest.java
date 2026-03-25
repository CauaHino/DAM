package es.ercilla.palindromo.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import es.ercilla.palindromo.Palindromo;

public class PalindromoTest {
	@Test
	@DisplayName("La palabra es palíndromo")
	void palabraPalindroma() {
		assertTrue(Palindromo.esPalindromo("oso"));
	}

	@Test
	@DisplayName("La palabra no es palíndromo")
	void palabraNoPalindroma() {
		assertFalse(Palindromo.esPalindromo("java"));
	}

	@Test
	@DisplayName("La palabra es null")
	void textoNull() {
		assertFalse(Palindromo.esPalindromo(null));
	}
}
