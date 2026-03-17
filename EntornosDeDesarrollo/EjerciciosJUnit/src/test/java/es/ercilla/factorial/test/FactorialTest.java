package es.ercilla.factorial.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import es.ercilla.factorial.Factorial;

import org.junit.jupiter.api.DisplayName;

class FactorialTest {

    @Test
    @DisplayName("Prueba de casos base: 0! y 1!")
    void testCasosBase() {
        assertEquals(1, Factorial.factorial(0), "El factorial de 0 debe ser 1");
        assertEquals(1, Factorial.factorial(1), "El factorial de 1 debe ser 1");
    }

    @Test
    @DisplayName("Prueba de valor positivo: 5!")
    void testFactorialPositivo() {
        // 5 * 4 * 3 * 2 * 1 = 120
        assertEquals(120, Factorial.factorial(5), "El factorial de 5 debe ser 120");
    }

    @Test
    @DisplayName("Robustez: Factorial de número negativo")
    void testFactorialNegativo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Factorial.factorial(-5);
        });
        
        String mensajeEsperado = "El número debe ser mayor o igual a 0";
        String mensajeActual = exception.getMessage();
        
        assertTrue(mensajeActual.contains(mensajeEsperado));
    }
}