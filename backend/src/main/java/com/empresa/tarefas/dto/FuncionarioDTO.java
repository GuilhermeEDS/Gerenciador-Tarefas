package com.empresa.tarefas.dto;

import com.empresa.tarefas.entity.Funcionario;

public class FuncionarioDTO {

    public String nome;

    public String cpf;

    public String senha;

    public FuncionarioDTO(String nome, String cpf, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Funcionario toFuncionario() {
        return new Funcionario(this.getNome(), this.getCpf());
    }
}
