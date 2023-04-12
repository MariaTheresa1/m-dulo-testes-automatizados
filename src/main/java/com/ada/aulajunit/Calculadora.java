package com.ada.aulajunit;

public class Calculadora {

    private int numero1;
    private int numero2;

    public Calculadora(int numero1, int numero2) {
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    public Calculadora(){

    }

    public int getNumero1() {
        return numero1;
    }

    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public int getNumero2() {
        return numero2;
    }

    public void setNumero2(int numero2) {
        this.numero2 = numero2;
    }

    public int somar(int n1, int n2){
        return n1 + n2;
    }

    public int subtrair(int n1, int n2){
        return n1 + n2;
    }

    public int multiplicar(int n1, int n2){
        return n1 * n2;
    }

    public int dividir(int n1, int n2){
        return n1 / n2;
    }

    public static void main(String[] args) {

    }
}
