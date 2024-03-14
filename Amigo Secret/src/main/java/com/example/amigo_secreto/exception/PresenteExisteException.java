package com.example.amigo_secreto.exception;

public class PresenteExisteException extends Exception{
    private String apelido;
    private String categoria;
    public PresenteExisteException(String apelido, String categoria){
        super("Já existe esse presente na lista do usuário " + apelido + categoria);
        this.apelido = apelido;
    }

    public String getApelido() {
        return apelido;
    }
    public String getCategoria() {
        return categoria;
    }

}


