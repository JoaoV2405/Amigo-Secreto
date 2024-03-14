package com.example.amigo_secreto.negocio.beans;

import java.util.ArrayList;

public class Participante {
    private String nome;
    private String apelido;
    private String senha;
    private ArrayList<Presente> presente;
    private String amigoSecreto;

    public String getAmigoSecreto() {
        return amigoSecreto;
    }

    public void setAmigoSecreto(String amigoSecreto) {
        this.amigoSecreto = amigoSecreto;
    }

    public Participante(String apelido){
        this.presente = new ArrayList<>();
        this.apelido = apelido;
    }
    public Participante(String apelido, String nome,String senha){
        this.presente = new ArrayList<>();
        this.apelido = apelido;
        this.nome = nome;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Presente> getPresente() {
        return presente;
    }

    public void setPresente(ArrayList<Presente> presente) {
        this.presente = presente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Participante " +
                apelido;
    }
}

