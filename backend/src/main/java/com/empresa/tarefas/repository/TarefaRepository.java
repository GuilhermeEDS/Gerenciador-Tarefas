package com.empresa.tarefas.repository;

import com.empresa.tarefas.dto.FuncionarioDTO;
import com.empresa.tarefas.entity.Tarefa;
import com.empresa.tarefas.enumeration.Situacao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TarefaRepository extends CrudRepository<Tarefa, Long> {

    @Query("SELECT t FROM Tarefa t WHERE (:numero = 0 OR t.id = :numero) AND lower(t.titulo) LIKE %:tituloDes% AND lower(t.descricao) LIKE %:tituloDes% AND lower(t.responsavel.nome) LIKE %:responsavel% AND t.situacao = :situacao")
    List<Tarefa> searchBy(@Param("numero") Long numero, @Param("tituloDes") String tituloDes,@Param("responsavel") String responsavel, @Param("situacao") Situacao situacao);
}
