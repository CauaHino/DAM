package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.*;

public class NumeroParTest {
	
	@Test
	@DisplayName("Un número par devuelve true")
	
	void numeroPar() {
		boolean resultado = Validacion.validacion(4);
		assertEquals(true, resultado);
	}
	
	
	@Test
	@DisplayName("Un número ímpar devuelve false")
	void numeroImpar() {
		boolean resultado = Validacion.validacion(5);
		assertEquals(false, resultado);
	}
	
	@Test
	@DisplayName("El cero se considera par")
	
	void numeroCero() {
		boolean resultado = Validacion.validacion(0);
		assertEquals(true,resultado);
	}

}
