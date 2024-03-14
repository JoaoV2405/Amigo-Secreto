package com.example.amigo_secreto.exception;

public class GrupoExisteException extends Exception{
    private String nome;
    public GrupoExisteException(String nome){
        super("Já existe um grupo com o nome " + nome);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

