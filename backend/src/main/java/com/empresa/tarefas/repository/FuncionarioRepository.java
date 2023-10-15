package com.empresa.tarefas.repository;

import com.empresa.tarefas.dto.FuncionarioDTO;
import com.empresa.tarefas.entity.Funcionario;
import com.empresa.tarefas.entity.Tarefa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {
    Optional<Funcionario> findByCpf(String cpf);

    @Query("SELECT f FROM Funcionario f WHERE lower(f.nome) LIKE %:nome% and lower(f.cpf) LIKE %:cpf%")
    List<Funcionario> searchByNomeAndCpf(@Param("nome") String nome, @Param("cpf") String cpf);
}
