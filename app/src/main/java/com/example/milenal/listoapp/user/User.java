package com.example.milenal.listoapp.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User implements Serializable {

    private String id;
    private String email;
    private String nome;
    private Date data_nascimento;
    private Date data_integracao;
    private String ramo;
    private String cargo;
    private String senha;
    private List<Boolean> compromemetimentoCidadania;
    private List<Boolean> insigniaAprenderPioneiro;
    private List<Boolean> insigniaConeSulPioneiro;
    private List<Boolean> insigniaLusofoniaPioneiro;
    private List<Boolean> insigniaAprenderLobinho;
    private List<Boolean> insigniaConeSulLobinho;
    private List<Boolean> insigniaBoaAcaoLobinho;
    private List<Boolean> insigniaLusofoniaLobinho;
    private List<Boolean> insigniaAprenderEscoteiro;
    private List<Boolean> insigniaConeSulEscoteiro;
    private List<Boolean> insigniaAcaoComunitariaEscoteiro;
    private List<Boolean> insigniaLusofoniaEscoteiro;
    private List<Boolean> insigniaAprenderSenior;
    private List<Boolean> insigniaConeSulSenior;
    private List<Boolean> insigniaDesafioComunitarioSenior;
    private List<Boolean> insigniaLusofoniaSenior;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User() { }

    public User(String email, String nome, Date data_nascimento, Date data_integracao, String ramo, String cargo, String senha) {
        this.email = email;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.data_integracao = data_integracao;
        this.ramo = ramo;
        this.cargo = cargo;
        this.senha = senha;
    }

    public User(String id, String email, String nome, Date data_nascimento, Date data_integracao, String ramo, String cargo, String senha, List<Boolean> compromemetimentoCidadania, List<Boolean> insigniaAprenderPioneiro, List<Boolean> insigniaConeSulPioneiro, List<Boolean> insigniaLusofoniaPioneiro, List<Boolean> insigniaAprenderLobinho, List<Boolean> insigniaConeSulLobinho, List<Boolean> insigniaBoaAcaoLobinho, List<Boolean> insigniaLusofoniaLobinho, List<Boolean> insigniaAprenderEscoteiro, List<Boolean> insigniaConeSulEscoteiro, List<Boolean> insigniaAcaoComunitariaEscoteiro, List<Boolean> insigniaLusofoniaEscoteiro, List<Boolean> insigniaAprenderSenior, List<Boolean> insigniaConeSulSenior, List<Boolean> insigniaDesafioComunitarioSenior, List<Boolean> insigniaLusofoniaSenior) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.data_integracao = data_integracao;
        this.ramo = ramo;
        this.cargo = cargo;
        this.senha = senha;
        this.compromemetimentoCidadania = compromemetimentoCidadania;
        this.insigniaAprenderPioneiro = insigniaAprenderPioneiro;
        this.insigniaConeSulPioneiro = insigniaConeSulPioneiro;
        this.insigniaLusofoniaPioneiro = insigniaLusofoniaPioneiro;
        this.insigniaAprenderLobinho = insigniaAprenderLobinho;
        this.insigniaConeSulLobinho = insigniaConeSulLobinho;
        this.insigniaBoaAcaoLobinho = insigniaBoaAcaoLobinho;
        this.insigniaLusofoniaLobinho = insigniaLusofoniaLobinho;
        this.insigniaAprenderEscoteiro = insigniaAprenderEscoteiro;
        this.insigniaConeSulEscoteiro = insigniaConeSulEscoteiro;
        this.insigniaAcaoComunitariaEscoteiro = insigniaAcaoComunitariaEscoteiro;
        this.insigniaLusofoniaEscoteiro = insigniaLusofoniaEscoteiro;
        this.insigniaAprenderSenior = insigniaAprenderSenior;
        this.insigniaConeSulSenior = insigniaConeSulSenior;
        this.insigniaDesafioComunitarioSenior = insigniaDesafioComunitarioSenior;
        this.insigniaLusofoniaSenior = insigniaLusofoniaSenior;
    }

    public List<Boolean> getCompromemetimentoCidadania() {
        if(compromemetimentoCidadania.isEmpty()) {
            for(int i = 0; i < 70; i++){
                compromemetimentoCidadania.add(Boolean.FALSE);
            }
        }
        return compromemetimentoCidadania;
    }

    public void setCompromemetimentoCidadania(List<Boolean> compromemetimentoCidadania) {
        this.compromemetimentoCidadania = compromemetimentoCidadania;
    }

    public List<Boolean> getInsigniaAprenderPioneiro() {
        if(insigniaAprenderPioneiro.isEmpty()) {
            for(int i = 0; i < 30; i++){
                insigniaAprenderPioneiro.add(Boolean.FALSE);
            }
        }
        return insigniaAprenderPioneiro;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", data_nascimento=" + data_nascimento +
                ", data_integracao=" + data_integracao +
                ", ramo='" + ramo + '\'' +
                ", cargo='" + cargo + '\'' +
                ", senha='" + senha + '\'' +
                ", compromemetimentoCidadania=" + compromemetimentoCidadania +
                ", insigniaAprenderPioneiro=" + insigniaAprenderPioneiro +
                ", insigniaConeSulPioneiro=" + insigniaConeSulPioneiro +
                ", insigniaLusofoniaPioneiro=" + insigniaLusofoniaPioneiro +
                ", insigniaAprenderLobinho=" + insigniaAprenderLobinho +
                ", insigniaConeSulLobinho=" + insigniaConeSulLobinho +
                ", insigniaBoaAcaoLobinho=" + insigniaBoaAcaoLobinho +
                ", insigniaLusofoniaLobinho=" + insigniaLusofoniaLobinho +
                ", insigniaAprenderEscoteiro=" + insigniaAprenderEscoteiro +
                ", insigniaConeSulEscoteiro=" + insigniaConeSulEscoteiro +
                ", insigniaAcaoComunitariaEscoteiro=" + insigniaAcaoComunitariaEscoteiro +
                ", insigniaLusofoniaEscoteiro=" + insigniaLusofoniaEscoteiro +
                ", insigniaAprenderSenior=" + insigniaAprenderSenior +
                ", insigniaConeSulSenior=" + insigniaConeSulSenior +
                ", insigniaDesafioComunitarioSenior=" + insigniaDesafioComunitarioSenior +
                ", insigniaLusofoniaSenior=" + insigniaLusofoniaSenior +
                '}';
    }

    public void setInsigniaAprenderPioneiro(List<Boolean> insigniaAprenderPioneiro) {
        this.insigniaAprenderPioneiro = insigniaAprenderPioneiro;
    }

    public List<Boolean> getInsigniaConeSulPioneiro() {
        if(insigniaConeSulPioneiro.isEmpty()) {
            for(int i = 0; i < 30; i++){
                insigniaConeSulPioneiro.add(Boolean.FALSE);
            }
        }
        return insigniaConeSulPioneiro;
    }

    public void setInsigniaConeSulPioneiro(List<Boolean> insigniaConeSulPioneiro) {
        this.insigniaConeSulPioneiro = insigniaConeSulPioneiro;
    }

    public List<Boolean> getInsigniaLusofoniaPioneiro() {
        if(insigniaLusofoniaPioneiro.isEmpty()) {
            for(int i = 0; i < 30; i++){
                insigniaLusofoniaPioneiro.add(Boolean.FALSE);
            }
        }
        return insigniaLusofoniaPioneiro;
    }

    public void setInsigniaLusofoniaPioneiro(List<Boolean> insigniaLusofoniaPioneiro) {
        this.insigniaLusofoniaPioneiro = insigniaLusofoniaPioneiro;
    }

    public List<Boolean> getInsigniaAprenderLobinho() {
        if(insigniaAprenderLobinho.isEmpty()) {
            for(int i = 0; i < 30; i++){
                insigniaAprenderLobinho.add(Boolean.FALSE);
            }
        }
        return insigniaAprenderLobinho;
    }

    public void setInsigniaAprenderLobinho(List<Boolean> insigniaAprenderLobinho) {
        this.insigniaAprenderLobinho = insigniaAprenderLobinho;
    }

    public List<Boolean> getInsigniaConeSulLobinho() {
        if(insigniaConeSulLobinho.isEmpty()) {
            for(int i = 0; i < 30; i++){
                insigniaConeSulLobinho.add(Boolean.FALSE);
            }
        }
        return insigniaConeSulLobinho;
    }

    public void setInsigniaConeSulLobinho(List<Boolean> insigniaConeSulLobinho) {
        this.insigniaConeSulLobinho = insigniaConeSulLobinho;
    }

    public List<Boolean> getInsigniaBoaAcaoLobinho() {
        if(insigniaBoaAcaoLobinho.isEmpty()) {
            for(int i = 0; i < 30; i++){
                insigniaBoaAcaoLobinho.add(Boolean.FALSE);
            }
        }
        return insigniaBoaAcaoLobinho;
    }

    public void setInsigniaBoaAcaoLobinho(List<Boolean> insigniaBoaAcaoLobinho) {
        this.insigniaBoaAcaoLobinho = insigniaBoaAcaoLobinho;
    }

    public List<Boolean> getInsigniaLusofoniaLobinho() {
        if(insigniaLusofoniaLobinho.isEmpty()) {
            for(int i = 0; i < 30; i++){
                insigniaLusofoniaLobinho.add(Boolean.FALSE);
            }
        }
        return insigniaLusofoniaLobinho;
    }

    public void setInsigniaLusofoniaLobinho(List<Boolean> insigniaLusofoniaLobinho) {
        this.insigniaLusofoniaLobinho = insigniaLusofoniaLobinho;
    }

    public List<Boolean> getInsigniaAprenderEscoteiro() {
        if(insigniaAprenderEscoteiro.isEmpty()) {
            for(int i = 0; i < 30; i++){
                insigniaAprenderEscoteiro.add(Boolean.FALSE);
            }
        }
        return insigniaAprenderEscoteiro;
    }

    public void setInsigniaAprenderEscoteiro(List<Boolean> insigniaAprenderEscoteiro) {
        this.insigniaAprenderEscoteiro = insigniaAprenderEscoteiro;
    }

    public List<Boolean> getInsigniaConeSulEscoteiro() {
        if(insigniaConeSulEscoteiro.isEmpty()) {
            for(int i = 0; i < 30; i++){
                insigniaConeSulEscoteiro.add(Boolean.FALSE);
            }
        }
        return insigniaConeSulEscoteiro;
    }

    public void setInsigniaConeSulEscoteiro(List<Boolean> insigniaConeSulEscoteiro) {
        this.insigniaConeSulEscoteiro = insigniaConeSulEscoteiro;
    }

    public List<Boolean> getInsigniaAcaoComunitariaEscoteiro() {
        if(insigniaAcaoComunitariaEscoteiro.isEmpty()) {
            for(int i = 0; i < 30; i++){
                insigniaAcaoComunitariaEscoteiro.add(Boolean.FALSE);
            }
        }
        return insigniaAcaoComunitariaEscoteiro;
    }

    public void setInsigniaAcaoComunitariaEscoteiro(List<Boolean> insigniaAcaoComunitariaEscoteiro) {
        this.insigniaAcaoComunitariaEscoteiro = insigniaAcaoComunitariaEscoteiro;
    }

    public List<Boolean> getInsigniaLusofoniaEscoteiro() {
        if(insigniaLusofoniaEscoteiro.isEmpty()) {
            for(int i = 0; i < 30; i++){
                insigniaLusofoniaEscoteiro.add(Boolean.FALSE);
            }
        }
        return insigniaLusofoniaEscoteiro;
    }

    public void setInsigniaLusofoniaEscoteiro(List<Boolean> insigniaLusofoniaEscoteiro) {
        this.insigniaLusofoniaEscoteiro = insigniaLusofoniaEscoteiro;
    }

    public List<Boolean> getInsigniaAprenderSenior() {
        if(insigniaAprenderSenior.isEmpty()) {
            for(int i = 0; i < 30; i++){
                insigniaAprenderSenior.add(Boolean.FALSE);
            }
        }
        return insigniaAprenderSenior;
    }

    public void setInsigniaAprenderSenior(List<Boolean> insigniaAprenderSenior) {
        this.insigniaAprenderSenior = insigniaAprenderSenior;
    }

    public List<Boolean> getInsigniaConeSulSenior() {
        if(insigniaConeSulSenior.isEmpty()) {
            for(int i = 0; i < 30; i++){
                insigniaConeSulSenior.add(Boolean.FALSE);
            }
        }
        return insigniaConeSulSenior;
    }

    public void setInsigniaConeSulSenior(List<Boolean> insigniaConeSulSenior) {
        this.insigniaConeSulSenior = insigniaConeSulSenior;
    }

    public List<Boolean> getInsigniaDesafioComunitarioSenior() {
        if(insigniaDesafioComunitarioSenior.isEmpty()) {
            for(int i = 0; i < 30; i++){
                insigniaDesafioComunitarioSenior.add(Boolean.FALSE);
            }
        }
        return insigniaDesafioComunitarioSenior;
    }

    public void setInsigniaDesafioComunitarioSenior(List<Boolean> insigniaDesafioComunitarioSenior) {
        this.insigniaDesafioComunitarioSenior = insigniaDesafioComunitarioSenior;
    }

    public List<Boolean> getInsigniaLusofoniaSenior() {
        if(insigniaLusofoniaSenior.isEmpty()) {
            for(int i = 0; i < 30; i++){
                insigniaLusofoniaSenior.add(Boolean.FALSE);
            }
        }
        return insigniaLusofoniaSenior;
    }

    public void setInsigniaLusofoniaSenior(List<Boolean> insigniaLusofoniaSenior) {
        this.insigniaLusofoniaSenior = insigniaLusofoniaSenior;
    }

    public User(String email, String nome, String ramo, String senha){
        this.email = email;
        this.nome = nome;
        this.ramo = ramo;
        this.senha = senha;
        this.compromemetimentoCidadania = new ArrayList<Boolean>();
        this.insigniaAprenderPioneiro = new ArrayList<Boolean>();
        this.insigniaConeSulPioneiro = new ArrayList<Boolean>();
        this.insigniaLusofoniaPioneiro = new ArrayList<Boolean>();
        this.insigniaAprenderLobinho = new ArrayList<Boolean>();
        this.insigniaConeSulLobinho = new ArrayList<Boolean>();
        this.insigniaBoaAcaoLobinho = new ArrayList<Boolean>();
        this.insigniaLusofoniaLobinho = new ArrayList<Boolean>();
        this.insigniaAprenderEscoteiro = new ArrayList<Boolean>();
        this.insigniaConeSulEscoteiro = new ArrayList<Boolean>();
        this.insigniaAcaoComunitariaEscoteiro = new ArrayList<Boolean>();
        this.insigniaLusofoniaEscoteiro = new ArrayList<Boolean>();
        this.insigniaAprenderSenior = new ArrayList<Boolean>();
        this.insigniaConeSulSenior = new ArrayList<Boolean>();
        this.insigniaDesafioComunitarioSenior = new ArrayList<Boolean>();
        this.insigniaLusofoniaSenior = new ArrayList<Boolean>();

        this.getCompromemetimentoCidadania();
        this.getInsigniaAprenderPioneiro();
        this.getInsigniaConeSulPioneiro();
        this.getInsigniaLusofoniaPioneiro();
        this.getInsigniaAprenderLobinho();
        this.getInsigniaConeSulLobinho();
        this.getInsigniaBoaAcaoLobinho();
        this.getInsigniaLusofoniaLobinho();
        this.getInsigniaAprenderEscoteiro();
        this.getInsigniaConeSulEscoteiro();
        this.getInsigniaAcaoComunitariaEscoteiro();
        this.getInsigniaLusofoniaEscoteiro();
        this.getInsigniaAprenderSenior();
        this.getInsigniaConeSulSenior();
        this.getInsigniaDesafioComunitarioSenior();
        this.getInsigniaLusofoniaSenior();


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
