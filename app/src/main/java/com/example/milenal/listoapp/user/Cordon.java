package com.example.milenal.listoapp.user;

import java.util.Date;

public class Cordon {

    private String nome;
    private String item;
    private Date data;

    public Cordon() {
    }

    public Cordon(String nome, String item, Date data) {
        this.nome = nome;
        this.item = item;
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
