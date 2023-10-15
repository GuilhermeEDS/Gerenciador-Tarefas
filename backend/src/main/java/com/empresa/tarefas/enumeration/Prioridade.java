package com.empresa.tarefas.enumeration;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Prioridade {
    MEDIA("Média"), BAIXA("Baixa"), ALTA("Alta");

    private final String prioridade;

    Prioridade(String prioridade) {

        this.prioridade = prioridade;
    }

    public static Prioridade porId(int id) {
        return Prioridade.values()[id];
    }

    public String getPrioridade() {
        return prioridade;
    }
}
