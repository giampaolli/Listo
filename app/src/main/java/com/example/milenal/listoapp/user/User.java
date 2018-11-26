package com.example.milenal.listoapp.user;

import java.util.Date;

public class User {

    private String id;
    private String email;
    private String nome;
    private Date data_nascimento;
    private Date data_integracao;
    private String ramo;
    private String cargo;
    private String senha;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User() {

    }

    public User(String email, String nome, Date data_nascimento, Date data_integracao, String ramo, String cargo, String senha) {
        this.email = email;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.data_integracao = data_integracao;
        this.ramo = ramo;
        this.cargo = cargo;
        this.senha = senha;
    }

    public User(String email, String nome, String ramo, String senha){
        this.email = email;
        this.nome = nome;
        this.ramo = ramo;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public Date getData_integracao() {
        return data_integracao;
    }

    public void setData_integracao(Date data_integracao) {
        this.data_integracao = data_integracao;
    }

    public String getRamo() {
        return ramo;
    }

    public void setRamo(String ramo) {
        this.ramo = ramo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
