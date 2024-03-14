package com.example.amigo_secreto.dados;

import com.example.amigo_secreto.exception.ParticipanteExisteException;
import com.example.amigo_secreto.exception.ParticipanteNaoExisteException;
import com.example.amigo_secreto.exception.PresenteExisteException;
import com.example.amigo_secreto.exception.PresenteNaoExisteException;
import com.example.amigo_secreto.negocio.beans.Participante;
import com.example.amigo_secreto.negocio.beans.Presente;

import java.util.ArrayList;

public class RepositorioParticipante implements IRepositorioParticipante{
    private ArrayList<Participante> participantes;
    private RepositorioParticipante(){
        this.participantes = new ArrayList<>();
    }

    private static RepositorioParticipante instance;
    public static RepositorioParticipante getInstance() {
        if (instance == null){
            instance = new RepositorioParticipante();
        }
        return instance;
    }
    @Override
    public ArrayList<Participante> getparticipantes() {
        return participantes;
    }

    @Override
    public void removerparticipante(Participante participante) throws ParticipanteNaoExisteException {
        boolean usuarioExiste = false;
        int i;
        for (i = 0; i < this.participantes.size() && !usuarioExiste; i++) {
            Participante participante1 = this.participantes.get(i);
            if (participante1.equals(participante)) {
                usuarioExiste = true;
            }
        }
        if (usuarioExiste) {
            this.participantes.remove(i-1);
        }else throw new ParticipanteNaoExisteException(participante.getApelido());

    }

    @Override
    public void cadastrarparticipante(Participante participante) throws ParticipanteExisteException {
        if (participante != null) {
            String apelido = participante.getApelido();
            boolean participanteIgual = false;
            for (Participante novo : participantes) {
                if (novo.getApelido().equals(apelido)) {
                    participanteIgual = true;
                    break;
                }
            }
            if (!participanteIgual) {
                this.participantes.add(participante);
            }
            else{
                throw new ParticipanteExisteException(participante.getApelido());
            }
        }
    }
    public void cadastrarPresente(Participante participante, Presente presente)throws PresenteExisteException{
        if(participante!=null && presente!=null){
                if(participante.getPresente()==null){
                    participante.getPresente().add(presente);
                } else if ( participante.getPresente() != null && !participante.getPresente().contains(presente)) {
                    participante.getPresente().add(presente);
                } else throw new PresenteExisteException(participante.getApelido(), presente.getCategoria());
            }
    }
    public void delPresentePessoa(Participante participante, Presente presente) throws PresenteNaoExisteException {
        boolean presenteExiste = false;

        int i;
        for (i = 0; i < participante.getPresente().size() && !presenteExiste; i++) {
            Presente p = participante.getPresente().get(i);
            if (presente.getDescricao().equals(p.getDescricao())) {
                presenteExiste = true;
            }
        }
        if (presenteExiste) {
            participante.getPresente().remove(i-1);
        }
        else throw new PresenteNaoExisteException();
    }

}
