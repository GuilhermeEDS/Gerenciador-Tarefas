package com.empresa.tarefas.entity;

import com.empresa.tarefas.enumeration.Prioridade;
import com.empresa.tarefas.enumeration.Situacao;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Tarefa extends Entidade {

    @Column(nullable = false)
    private String titulo;
    @Column
    private String descricao;
    @ManyToOne
    private Funcionario responsavel;

    @Column(nullable = false)
    @JsonUnwrapped
    private Prioridade prioridade;

    @Column
    @JsonUnwrapped
    private Situacao situacao;

    @Column(nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date deadline;

    public Tarefa(String titulo, String descricao, Prioridade prioridade, Date deadline) {
        super();
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.deadline = deadline;
        this.situacao = Situacao.EMANDAMENTO;
    }

    public Tarefa() {
        super();
        this.situacao = Situacao.EMANDAMENTO;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Funcionario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Funcionario responsavel) {
        this.responsavel = responsavel;
    }

    public Prioridade getPrioridade(Prioridade prioridade) {
        return this.prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Date getDeadline(Date deadline) {
        return this.deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
