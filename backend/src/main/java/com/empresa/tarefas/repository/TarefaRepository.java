package com.empresa.tarefas.repository;

import com.empresa.tarefas.entity.Tarefa;
import org.springframework.data.repository.CrudRepository;

public interface TarefaRepository extends CrudRepository<Tarefa, Long> {
}
