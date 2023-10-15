package com.empresa.tarefas.dto;

import com.empresa.tarefas.entity.Funcionario;

public class LoginDTO {

    public String cpf;

    public String senha;

    public LoginDTO(String cpf, String senha) {
        this.cpf = cpf;
        this.senha = senha;
    }

    public LoginDTO() {
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
}
