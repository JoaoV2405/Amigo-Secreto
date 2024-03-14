package com.example.amigo_secreto.negocio.beans;

public class Presente {
    private String categoria;
    private String descricao;
    private float preco;

    public Presente(String categoria,String descricao,float preco) {
        this.categoria = categoria;
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Presente: " +
                 categoria +
                " - R$" + preco;
    }
}
