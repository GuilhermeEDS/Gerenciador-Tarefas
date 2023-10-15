package com.empresa.tarefas.entity;


import jakarta.persistence.*;

import java.util.Date;

@MappedSuperclass
public class Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Date dataCadastro;

    public Entidade() {
        this.dataCadastro = new Date();
    }

    public Long getId() {
        return id;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
