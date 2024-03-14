package com.example.amigo_secreto.negocio;

import com.example.amigo_secreto.dados.IRepositorioGrupo;
import com.example.amigo_secreto.dados.RepositorioGrupo;
import com.example.amigo_secreto.exception.GrupoExisteException;
import com.example.amigo_secreto.exception.ParticipanteExisteException;
import com.example.amigo_secreto.exception.ParticipanteNaoExisteException;
import com.example.amigo_secreto.negocio.beans.Grupo;
import com.example.amigo_secreto.negocio.beans.Participante;

import java.util.ArrayList;

public class ControladorGrupo {
    private IRepositorioGrupo rep;
    private static ControladorGrupo instance;
    public static ControladorGrupo getInstance() {
        if(instance == null){
            instance = new ControladorGrupo();
        }
        return instance;
    }
    private ControladorGrupo(){
        this.rep = RepositorioGrupo.getInstance();
    }
    public ArrayList<Grupo> getGrupos(){

        return this.rep.getGrupos();
    }
    public boolean addPessoaGrupo(Participante participante, Grupo grupo) throws ParticipanteExisteException{
        return this.rep.addPessoaGrupo(participante, grupo);
    }
    public void delPessoaGrupo(Participante participante, Grupo grupo) throws ParticipanteNaoExisteException {
        rep.delPessoaGrupo(participante, grupo);
    }
    public void cadastrarGrupo(Grupo grupo) throws GrupoExisteException{
        rep.cadastrarGrupo(grupo);
    }
}
