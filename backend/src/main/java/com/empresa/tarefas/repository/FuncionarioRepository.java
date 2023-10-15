package com.empresa.tarefas.repository;

import com.empresa.tarefas.entity.Funcionario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {
    Optional<Funcionario> findByCpf(String cpf);
}
