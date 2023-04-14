package com.ada.aulajunit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

public class CalculadoraParameterizedTest {

    

    @ParameterizedTest
    public void testeSoma(int primeiro, int segundo, int expected) {

        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.somar(primeiro, segundo);

        Assertions.assertEquals(expected, resultado);
    }

}
