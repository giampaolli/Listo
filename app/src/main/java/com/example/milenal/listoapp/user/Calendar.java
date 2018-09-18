package com.example.milenal.listoapp.user;

import java.util.Date;

public class Calendar {

    private String titulo;
    private String descricao;
    private Date data_inicio;
    private Date data_fim;
    private String local;
    private Date horario_inicio;
    private Date horario_fim;
    private String responsavel;
    private String participantes; //Array?
    private Boolean autorizacao;

    public Calendar() {
    }

    public Calendar(String titulo, String descricao, Date data_inicio, Date data_fim, String local, Date horario_inicio, Date horario_fim, String responsavel, String participantes, Boolean autorizacao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.local = local;
        this.horario_inicio = horario_inicio;
        this.horario_fim = horario_fim;
        this.responsavel = responsavel;
        this.participantes = participantes;
        this.autorizacao = autorizacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public String getLocal() {
        return local;
    }

    public Date getHorario_inicio() {
        return horario_inicio;
    }

    public Date getHorario_fim() {
        return horario_fim;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public String getParticipantes() {
        return participantes;
    }

    public Boolean getAutorizacao() {
        return autorizacao;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setHorario_inicio(Date horario_inicio) {
        this.horario_inicio = horario_inicio;
    }

    public void setHorario_fim(Date horario_fim) {
        this.horario_fim = horario_fim;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public void setParticipantes(String participantes) {
        this.participantes = participantes;
    }

    public void setAutorizacao(Boolean autorizacao) {
        this.autorizacao = autorizacao;
    }
}
