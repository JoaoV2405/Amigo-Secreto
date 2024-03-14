package com.example.amigo_secreto.exception;

public class DataMenorException extends Exception{
        private String nome;
        public DataMenorException(String nome){
            super("A data de hoje é menor que a data do sorteio do grupo " + nome);
            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }
    }

