package com.empresa.tarefas.enumeration;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Situacao {
    EMANDAMENTO("Em Andamento"), CONCLUIDA("Concluído"), CANCELADO("Cancelado");

    public final String situacao;

    Situacao(String situacao) {

        this.situacao = situacao;
    }

    public static Situacao porId(int id) {
        return Situacao.values()[id];
    }

    public String getSituacao() {
        return situacao;
    }
}
