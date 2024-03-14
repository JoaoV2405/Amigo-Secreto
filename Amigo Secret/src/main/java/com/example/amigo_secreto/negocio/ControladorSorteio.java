package com.example.amigo_secreto.negocio;
import java.time.LocalDate;
import java.util.*;

import com.example.amigo_secreto.exception.*;
import com.example.amigo_secreto.negocio.beans.Grupo;
import com.example.amigo_secreto.negocio.beans.Participante;
import com.example.amigo_secreto.negocio.beans.Presente;

public class ControladorSorteio {
    private ControladorGrupo cGrupo;
    private ControladorPresente cPresente;
    private ControladorParticipante cParticipante;
    private static ControladorSorteio instance;
    public static ControladorSorteio getInstance() {
        if(instance == null){
            instance = new ControladorSorteio();
        }
        return instance;
    }
    private ControladorSorteio(){
        this.cGrupo = ControladorGrupo.getInstance();
        this.cParticipante = ControladorParticipante.getInstance();
        this.cPresente = ControladorPresente.getInstance();
    }
    //

    public void sorteio2(Grupo grupo) throws DataMenorException, JaSorteadoException, ParticipantesInsuficientesException {
        if(grupo!=null) {
            if (grupo.getIntegrante().size() > 2) {
                if (grupo.isSorteado()) {
                    if (!LocalDate.now().isBefore(grupo.getData())) {
                        Collections.shuffle(grupo.getIntegrante());
                        for (int i = 0; i < grupo.getIntegrante().size(); i++) {
                            Participante p = grupo.getIntegrante().get(i);
                            if (i == grupo.getIntegrante().size() - 1) {
                                p.setAmigoSecreto(grupo.getIntegrante().get(0).getApelido());
                            } else p.setAmigoSecreto(grupo.getIntegrante().get(i + 1).getApelido());

                        }
                        for (int e = 0; e < grupo.getIntegrante().size(); e++) {
                            System.out.println(grupo.getIntegrante().get(e).getApelido() + grupo.getIntegrante().get(e).getAmigoSecreto());
                        }
                    } else throw new DataMenorException(grupo.getNome());
                    grupo.setSorteado(false);
                } else throw new JaSorteadoException();
            }else throw new ParticipantesInsuficientesException();
        }
    }



    public static void main(String[] args) throws GrupoExisteException, ParticipanteExisteException, PresenteExisteListaException, PresenteExisteException, DataMenorException, JaSorteadoException, ParticipantesInsuficientesException, ParticipanteNaoExisteException {
        ControladorSorteio c = ControladorSorteio.getInstance();
        Grupo gp = new Grupo("a", LocalDate.of(2000, 3,5));
        Participante pt = new Participante("a");
        Participante pt2 = new Participante("b");
        Participante pt22 = new Participante("c");
        Participante pt222 = new Participante("d");
        Participante pt2222 = new Participante("e");
        Presente presente = new Presente("a", "w",89.4f);
        presente.setDescricao("Dd");
        Presente presente1 = new Presente("b", "d",5f);
        presente1.setDescricao("dada");
        c.cPresente.cadastrarPresente(presente);
        c.cPresente.cadastrarPresente(presente1);
        c.cParticipante.cadastrarPresente(pt, presente);
        c.cParticipante.cadastrarPresente(pt, presente1);
        System.out.println(pt.getPresente());
        c.cGrupo.cadastrarGrupo(gp);
        c.cGrupo.addPessoaGrupo(pt, gp);
        System.out.println(gp.isSorteado());
        c.sorteio2(gp);
        System.out.println(gp.isSorteado());
        c.sorteio2(gp);

    }
}
