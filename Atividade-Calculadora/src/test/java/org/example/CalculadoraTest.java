package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {
    private Calculadora calc = new Calculadora();
    @Test
    public void testSomar() {
        assertEquals(5, calc.somar(2, 3));
        assertEquals(0, calc.somar(-2, 2));
    }
    // Testes para subtrair, multiplicar e dividir
    @Test
    public void testDividir() {
        assertEquals(2, calc.dividir(10, 5));
// Teste para divisão por zero
    }
}