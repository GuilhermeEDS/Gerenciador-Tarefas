package com.empresa.tarefas.dto;

import com.empresa.tarefas.entity.Funcionario;
import jakarta.validation.constraints.NotNull;

public class FuncionarioDTO {

    @NotNull(message = "Nome não pode ser vazio.")
    public String nome;
    @NotNull(message = "Cpf não pode ser vazio.")
    public String cpf;

    public FuncionarioDTO(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Funcionario toFuncionario() {
        return new Funcionario(this.getNome(), this.getCpf());
    }
}
