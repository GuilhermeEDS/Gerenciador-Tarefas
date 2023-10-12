package com.empresa.tarefas.entity;


import jakarta.persistence.*;

import java.util.Date;

@MappedSuperclass
public class Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Boolean ativo;

    @Column(nullable = false)
    private Date dataCadastro;

    public Entidade() {
        this.ativo = true;
        this.dataCadastro = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
