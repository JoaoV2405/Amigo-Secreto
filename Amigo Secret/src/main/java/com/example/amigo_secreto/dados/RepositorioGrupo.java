package com.example.amigo_secreto.dados;

import com.example.amigo_secreto.exception.GrupoExisteException;
import com.example.amigo_secreto.exception.ParticipanteExisteException;
import com.example.amigo_secreto.exception.ParticipanteNaoExisteException;
import com.example.amigo_secreto.negocio.beans.Grupo;
import com.example.amigo_secreto.negocio.beans.Participante;

import java.util.ArrayList;

public class RepositorioGrupo implements IRepositorioGrupo{
    private ArrayList<Grupo> grupos;
    private RepositorioGrupo(){
        this.grupos = new ArrayList<>();
    }

    private static RepositorioGrupo instance;
    public static RepositorioGrupo getInstance() {
        if (instance == null){
            instance = new RepositorioGrupo();
        }
        return instance;
    }

    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }
    public boolean addPessoaGrupo(Participante participante, Grupo grupo) throws ParticipanteExisteException {
        boolean resultado = false;
        if (participante != null && grupo != null) {
                if (!grupo.getIntegrante().contains(participante)) {
                    grupo.getIntegrante().add(participante);
                    resultado = true;
                }
                else{
                    throw new ParticipanteExisteException(participante.getApelido());
                }
        }
        return resultado;
    }
    public void delPessoaGrupo(Participante participante, Grupo grupo) throws  ParticipanteNaoExisteException {
        boolean usuarioExiste = false;

        int i;
        for (i = 0; i < grupo.getIntegrante().size() && !usuarioExiste; i++) {
            Participante pessoa = grupo.getIntegrante().get(i);
            if (pessoa.getApelido().equals(participante.getApelido())) {
                usuarioExiste = true;
            }
        }
        if (usuarioExiste) {
            grupo.getIntegrante().remove(i-1);
        }
        else throw new ParticipanteNaoExisteException(participante.getApelido());
    }

    public void cadastrarGrupo(Grupo grupo) throws GrupoExisteException {
        if (grupo != null) {
            String nome = grupo.getNome();
            boolean grupoIgual = false;
            for (Grupo novo : grupos) {
                if (novo.getNome().equals(nome)) {
                    grupoIgual = true;
                    break;
                }
            }
            if (!grupoIgual) {
                this.grupos.add(grupo);
            }
            else{
                throw new GrupoExisteException(grupo.getNome());
            }
        }
    }

//    public static void main(String[] args) throws GrupoExisteException, ParticipanteExisteException {
//        RepositorioGrupo rp = new RepositorioGrupo();
//        Grupo gp = new Grupo("a");
//        Participante pt = new Participante("a");
//        pt.setApelido("s");
//        Participante pt2 = new Participante("b");
//        Participante pt22 = new Participante("c");
//        rp.cadastrarGrupo(gp);
//        rp.addPessoaGrupo(pt,gp);
//        rp.addPessoaGrupo(pt2,gp);
//        rp.addPessoaGrupo(pt22,gp);
//
//
//    }
}
