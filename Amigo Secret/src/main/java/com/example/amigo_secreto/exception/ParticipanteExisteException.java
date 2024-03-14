package com.example.amigo_secreto.exception;

public class ParticipanteExisteException extends Exception {
    public String apelido;
    public ParticipanteExisteException(String apelido){
        super("Já existe um usuário com o apelido " + apelido);
        this.apelido = apelido;
    }

    public String getApelido() {
        return apelido;
    }
}

