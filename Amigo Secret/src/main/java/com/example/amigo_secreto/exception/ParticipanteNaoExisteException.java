package com.example.amigo_secreto.exception;

public class ParticipanteNaoExisteException extends Exception {
    private String apelido;
    public ParticipanteNaoExisteException(String apelido){
        super("O usuário " + apelido+ " não está na lista");
        this.apelido = apelido;
    }

    public String getApelido() {
        return apelido;
    }
}
