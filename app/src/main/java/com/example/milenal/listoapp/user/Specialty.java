package com.example.milenal.listoapp.user;

import java.util.Date;

public class Specialty {

    private String nome;
    private Date data;
    private String area_conhecimento;

    public Specialty() {
    }

    public Specialty(String nome, Date data, String area_conhecimento) {
        this.nome = nome;
        this.data = data;
        this.area_conhecimento = area_conhecimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getArea_conhecimento() {
        return area_conhecimento;
    }

    public void setArea_conhecimento(String area_conhecimento) {
        this.area_conhecimento = area_conhecimento;
    }
}
