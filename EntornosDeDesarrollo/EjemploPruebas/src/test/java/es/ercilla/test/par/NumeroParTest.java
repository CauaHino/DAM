package es.ercilla.test.par;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import es.ercilla.par.NumeroPar;

class NumeroParTest {

	@Test
	@DisplayName("Un número par devuelve true")
	void numeroPar() {
		boolean resultado = NumeroPar.esPar(4);
		assertEquals(true, resultado);
	}

	@Test
	@DisplayName("Un número impar devuelve false")
	void numeroImpar() {
		boolean resultado = NumeroPar.esPar(5);
		assertEquals(false, resultado);
	}

	@Test
	@DisplayName("El cero se considera par")
	void ceroEsPar() {
		boolean resultado = NumeroPar.esPar(0);
		assertTrue(resultado);
	}
}
