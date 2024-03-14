package com.example.amigo_secreto.negocio;

import com.example.amigo_secreto.dados.IRepositorioPresente;
import com.example.amigo_secreto.dados.RepositorioPresente;
import com.example.amigo_secreto.exception.PresenteExisteListaException;
import com.example.amigo_secreto.exception.PresenteNaoExisteException;
import com.example.amigo_secreto.negocio.beans.Presente;

import java.util.ArrayList;

public class ControladorPresente {
    private IRepositorioPresente rep;
    private static ControladorPresente instance;
    public static ControladorPresente getInstance() {
        if(instance == null){
            instance = new ControladorPresente();
        }
        return instance;
    }
    private ControladorPresente(){
        this.rep = RepositorioPresente.getInstance();
    }
    public ArrayList<Presente>getPresentes(){
        return this.rep.getPresentes();
    }
    public void cadastrarPresente(Presente presente) throws PresenteExisteListaException {
        this.rep.cadastrarPresente(presente);
    }
    public void delPresente(Presente presente) throws PresenteNaoExisteException {
        this.rep.delPresente(presente);
    }

}
