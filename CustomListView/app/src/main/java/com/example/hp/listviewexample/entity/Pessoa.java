package com.example.hp.listviewexample.entity;

import java.util.Date;

/**
 * Created by IFPB on 12/09/2016.
 */
public class Pessoa {

    //cria o contrutor de Pessoa
    public Pessoa(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
    private String nome;

    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
