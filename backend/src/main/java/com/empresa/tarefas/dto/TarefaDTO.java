package com.empresa.tarefas.dto;

import com.empresa.tarefas.entity.Tarefa;
import com.empresa.tarefas.enumeration.Prioridade;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class TarefaDTO {
    @NotEmpty(message = "Título não pode ser vazio.")
    private String titulo;

    private String descricao;

    @NotNull(message = "Selecione um funcionario")
    private Long idFuncionario;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future(message = "Data da Deadline deve ser uma data futura.")
    @NotNull(message = "Data da Deadline não pode ser vazia.")
    private Date deadline;

    @NotNull(message = "Selecione uma prioridade")
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
