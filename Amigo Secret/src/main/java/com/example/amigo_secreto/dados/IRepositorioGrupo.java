package com.example.amigo_secreto.dados;

import com.example.amigo_secreto.exception.GrupoExisteException;
import com.example.amigo_secreto.exception.ParticipanteExisteException;
import com.example.amigo_secreto.exception.ParticipanteNaoExisteException;
import com.example.amigo_secreto.negocio.beans.Grupo;
import com.example.amigo_secreto.negocio.beans.Participante;

import java.util.ArrayList;

public interface IRepositorioGrupo {
    public ArrayList<Grupo> getGrupos();
    public boolean addPessoaGrupo(Participante participante, Grupo grupo) throws ParticipanteExisteException;
    public void delPessoaGrupo(Participante participante, Grupo grupo) throws  ParticipanteNaoExisteException;
    public void cadastrarGrupo(Grupo grupo) throws GrupoExisteException;

    }
