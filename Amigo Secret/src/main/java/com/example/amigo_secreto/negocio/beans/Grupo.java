package com.example.amigo_secreto.negocio.beans;

import java.time.LocalDate;
import java.util.ArrayList;

public class Grupo {
    private boolean sorteado;
    private LocalDate data;
    private String nome;
    private ArrayList<Participante> integrante;
    public Grupo(String nome, LocalDate data){
        this.sorteado = true;
        this.integrante = new ArrayList<>();
        this.nome = nome;
        this.data = data;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Participante> getIntegrante() {
        return integrante;
    }

    public void setIntegrante(ArrayList<Participante> integrante) {
        this.integrante = integrante;
    }

    public boolean isSorteado() {
        return sorteado;
    }

    public void setSorteado(boolean sorteado) {
        this.sorteado = sorteado;
    }

    @Override
    public String toString() {
        return "Grupo " +
                nome;
    }
}
