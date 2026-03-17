package es.ercilla.fibonacci.recursivo.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import es.ercilla.fibonacci.recursivo.FibonacciRecursivo;

import org.junit.jupiter.api.DisplayName;

class FibonacciRecursivoTest {

    @Test
    @DisplayName("Prueba de valores base: n=0 y n=1")
    void testValoresBase() {
        assertEquals(0, FibonacciRecursivo.fibonacci(0), "Fibonacci de 0 debe ser 0");
        assertEquals(1, FibonacciRecursivo.fibonacci(1), "Fibonacci de 1 debe ser 1");
    }

    @Test
    @DisplayName("Prueba de valor normal: n=6")
    void testValorNormal() {
        // Serie: 0, 1, 1, 2, 3, 5, 8...
        assertEquals(8, FibonacciRecursivo.fibonacci(6), "Fibonacci de 6 debe ser 8");
    }
}