package com.example.amigo_secreto.dados;

import com.example.amigo_secreto.exception.PresenteExisteListaException;
import com.example.amigo_secreto.exception.PresenteNaoExisteException;
import com.example.amigo_secreto.negocio.beans.Presente;

import java.util.ArrayList;

public interface IRepositorioPresente {
     ArrayList<Presente> getPresentes();
    void cadastrarPresente(Presente presente) throws PresenteExisteListaException;
    void delPresente(Presente presente) throws PresenteNaoExisteException;

}
