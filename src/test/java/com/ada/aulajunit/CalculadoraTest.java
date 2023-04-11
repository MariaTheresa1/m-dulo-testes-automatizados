package com.ada.aulajunit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
class CalculadoraTest {

    // Casos de testes do método somar:
    // 1. Dados 2 numeros positivos, quando o primeiro for maior que o segundo, então a soma deve ser positiva
    // 2. 2 numeros positivos, sendo o primeiro menor que o segundo
    // 3. numeros positivos iguais
    // 4. primeiro negativo, segundo positivo
    // 5. primeiro positivo, segundo negativo
    // 6. 2 números de mesmo valor absoluto, mas sinais diferentes
    // 7. zero e um numero positivo
    // 8. zero e um numero negativo
    // 9. um numero positivo e zero
    // 10. um numero negativo e e zero
    // 11. 2 numeros negativos, sendo o primeiro maior que o segundo
    // 12. 2 numeros negativos, sendo o primeiro menor que o segundo
    // 13. numeros negativos iguais

    // 1.
    @Test
    public void dado2NumerosPositivos_QuandoOPrimeiroÉMaiorQueOSegundo_EntaoResultadoDeveSerPositivo() {
        int primeiro = 10;
        int segundo = 2;

        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.somar(primeiro, segundo);

        Assertions.assertTrue(resultado > 0);
    }

    // 2.
    @Test
    public void dado2NumerosPositivos_QuandoOPrimeiroÉMenorQueOSegundo_EntaoResultadoDeveSerMaiorIgualAoSegundo() {
        int primeiro = 2;
        int segundo = 10;

        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.somar(primeiro, segundo);

        Assertions.assertTrue(resultado >= segundo);
    }

    // 12.
    @Test
    public void dado2NumerosNegativos_QuandoOPrimeiroÉMenorQueOSegundo_EntaoResultadoDeveSerMenorQueZero() {
        int primeiro = -10;
        int segundo = -2;

        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.somar(primeiro, segundo);

        Assertions.assertTrue(resultado < 0);
    }

}