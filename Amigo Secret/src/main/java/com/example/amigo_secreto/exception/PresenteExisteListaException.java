package com.example.amigo_secreto.exception;

public class PresenteExisteListaException extends Exception{
    public PresenteExisteListaException(){
        super("Já existe esse presente na lista");
    }

}


