package com.empresa.tarefas.config;

public class MensagemLogin {
        String mensagem;
        Boolean status;

    public MensagemLogin(String mensagem, Boolean status) {
        this.mensagem = mensagem;
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
