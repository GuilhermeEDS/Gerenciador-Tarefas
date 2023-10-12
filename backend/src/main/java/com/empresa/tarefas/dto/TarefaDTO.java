package com.empresa.tarefas.dto;

import com.empresa.tarefas.entity.Tarefa;
import com.empresa.tarefas.enumeration.Prioridade;

import java.util.Date;

public class TarefaDTO {

    private String titulo;

    private String descricao;

    private Long idFuncionario;

    private Date deadline;

    private Integer prioridade;

    public TarefaDTO(String titulo, String descricao, Long idFuncionario, Date deadline, Integer prioridade) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.idFuncionario = idFuncionario;
        this.deadline = deadline;
        this.prioridade = prioridade;
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

    public Long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Integer getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }

    public Tarefa toTarefa() {
        return new Tarefa(this.titulo, this.descricao, Prioridade.porId(this.prioridade), this.deadline);
    }

}
