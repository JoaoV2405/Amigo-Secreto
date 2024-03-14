package com.example.amigo_secreto.exception;

public class PresenteNaoExisteException extends Exception{
    public PresenteNaoExisteException(){
        super("Não existe esse presente na lista");
    }
}
