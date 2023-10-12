package com.empresa.tarefas.enumeration;

public enum Prioridade {
    MEDIA("Média"), BAIXA("Baixa"), ALTA("Alta");

    private final String descricao;

    Prioridade(String descricao) {
        this.descricao = descricao;
    }

    public static Prioridade porId(int id) {
        return Prioridade.values()[id];
    }

    public String getDescricao() {
        return descricao;
    }
}
