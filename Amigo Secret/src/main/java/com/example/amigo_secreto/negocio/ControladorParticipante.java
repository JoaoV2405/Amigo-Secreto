package com.example.amigo_secreto.negocio;

import com.example.amigo_secreto.dados.IRepositorioParticipante;
import com.example.amigo_secreto.dados.RepositorioParticipante;
import com.example.amigo_secreto.exception.ParticipanteExisteException;
import com.example.amigo_secreto.exception.PresenteExisteException;
import com.example.amigo_secreto.exception.*;
import com.example.amigo_secreto.negocio.beans.Participante;
import com.example.amigo_secreto.negocio.beans.Presente;

import java.util.ArrayList;

public class ControladorParticipante {
    private IRepositorioParticipante rep;
    private static ControladorParticipante instance;
    public static ControladorParticipante getInstance() {
        if(instance == null){
            instance = new ControladorParticipante();
        }
        return instance;
    }
    private ControladorParticipante(){
        this.rep = RepositorioParticipante.getInstance();
    }
    public ArrayList<Participante> getparticipantes(){
        return this.rep.getparticipantes();
    }

    public void removerparticipante(Participante participante) throws ParticipanteNaoExisteException {
         this.rep.removerparticipante(participante);
    }

    public void cadastrarparticipante(Participante participante) throws ParticipanteExisteException {
         this.rep.cadastrarparticipante(participante);
    }
    public void cadastrarPresente(Participante participante, Presente presente)throws PresenteExisteException{
        this.rep.cadastrarPresente(participante, presente);
    }
    public void delPresentePessoa(Participante participante, Presente presente) throws PresenteNaoExisteException {
        this.rep.delPresentePessoa(participante, presente);
    }


        public static void main(String[] args) throws ParticipanteExisteException {
        Participante pt = new Participante("a");
        Participante pt2 = new Participante("b");
        Participante pt22 = new Participante("c");
        Participante pt222 = new Participante("d");
        Participante pt2222 = new Participante("e");
        ControladorParticipante.getInstance().cadastrarparticipante(pt);
        ControladorParticipante.getInstance().cadastrarparticipante(pt2);
        ControladorParticipante.getInstance().cadastrarparticipante(pt22);
        ControladorParticipante.getInstance().cadastrarparticipante(pt222);
        ControladorParticipante.getInstance().cadastrarparticipante(pt2222);
        System.out.println(ControladorParticipante.getInstance().getparticipantes());
    }
}
