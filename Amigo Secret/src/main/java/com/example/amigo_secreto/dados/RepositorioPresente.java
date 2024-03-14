package com.example.amigo_secreto.dados;

import com.example.amigo_secreto.exception.PresenteExisteListaException;
import com.example.amigo_secreto.exception.PresenteNaoExisteException;
import com.example.amigo_secreto.negocio.beans.Presente;

import java.util.ArrayList;

public class RepositorioPresente implements IRepositorioPresente{
    private ArrayList<Presente>presentes;
    private static RepositorioPresente instance;

    private RepositorioPresente(){
        this.presentes = new ArrayList<>();
    }

    public static RepositorioPresente getInstance() {
        if (instance == null){
            instance = new RepositorioPresente();
        }
        return instance;
    }

    public ArrayList<Presente> getPresentes() {
        return presentes;
    }

    @Override
    public void cadastrarPresente(Presente presente) throws PresenteExisteListaException {
        if(presente!=null){
                String descricao = presente.getDescricao();
                float preco = presente.getPreco();
                String categoria = presente.getCategoria();
                boolean participanteIgual = false;
                for (Presente novo : presentes) {
                    if (novo.getDescricao().equals(descricao) && novo.getPreco()==preco &&novo.getCategoria().equals(categoria)) {
                        participanteIgual = true;
                        break;
                    }
                }
                if (!participanteIgual) {
                    this.presentes.add(presente);
                }
                else{
                    throw new PresenteExisteListaException();
                }
        }
    }

    @Override
    public void delPresente(Presente presente) throws PresenteNaoExisteException {
        boolean existe = false;
        int i;
        for (i = 0; i < this.presentes.size() && !existe; i++) {
            Presente presente1 = this.presentes.get(i);
            if (presente1.equals(presente)) {
                existe = true;
            }
        }
        if (existe) {
            this.presentes.remove(i - 1);
        }
        else throw new PresenteNaoExisteException();
    }
   }