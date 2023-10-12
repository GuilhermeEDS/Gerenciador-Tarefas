package com.empresa.tarefas.repository;

import com.empresa.tarefas.entity.Funcionario;
import org.springframework.data.repository.CrudRepository;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {
}
