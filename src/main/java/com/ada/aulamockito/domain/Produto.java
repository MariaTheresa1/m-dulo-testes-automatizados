package com.ada.aulamockito.domain;

public class Produto {
    private String nome;
    private Double valor;
    private Integer codigo;

    public Produto(String nome, Double valor, Integer codigo) {
        this.nome = nome;
        this.valor = valor;
        this.codigo = codigo;
    }

    public Produto(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
}
