package com.example.amigo_secreto.dados;

import com.example.amigo_secreto.exception.ParticipanteExisteException;
import com.example.amigo_secreto.exception.ParticipanteNaoExisteException;
import com.example.amigo_secreto.exception.PresenteExisteException;
import com.example.amigo_secreto.exception.PresenteNaoExisteException;
import com.example.amigo_secreto.negocio.beans.Participante;
import com.example.amigo_secreto.negocio.beans.Presente;

import java.util.ArrayList;

public interface IRepositorioParticipante {

        ArrayList<Participante> getparticipantes();
        void delPresentePessoa(Participante participante, Presente presente) throws PresenteNaoExisteException;
        void removerparticipante(Participante participante) throws ParticipanteNaoExisteException;

        void cadastrarparticipante(Participante participante) throws ParticipanteExisteException;
        void cadastrarPresente(Participante participante, Presente presente)throws PresenteExisteException;
}
