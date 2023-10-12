package com.empresa.tarefas.service;

import com.empresa.tarefas.dto.TarefaDTO;
import com.empresa.tarefas.entity.Funcionario;
import com.empresa.tarefas.entity.Tarefa;
import com.empresa.tarefas.enumeration.Prioridade;
import com.empresa.tarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    TarefaRepository tarefaRepository;

    @Autowired
    FuncionarioService funcionarioService;

    public Iterable<Tarefa> listarTarefas() {
        return tarefaRepository.findAll();
    }

    public Tarefa porId(Long id) {
        Optional<Tarefa> tarefa = tarefaRepository.findById(id);
        if (tarefa.isEmpty()) {
            //adicionar Exception
            return null;
        }
        return tarefa.get();
    }

    public Tarefa criarTarefa(TarefaDTO tarefaDTO) {
        Funcionario responsavel = funcionarioService.porId(tarefaDTO.getIdFuncionario());
        Tarefa tarefa = tarefaDTO.toTarefa();
        tarefa.setResponsavel(responsavel);

        return tarefaRepository.save(tarefa);
    }

    public Tarefa atualizarTarefa(TarefaDTO tarefaDTO, Long id) {
        Tarefa tarefa = porId(id);

        tarefa.setTitulo(tarefaDTO.getTitulo());
        tarefa.setDescricao(tarefaDTO.getDescricao());
        tarefa.setDeadline(tarefaDTO.getDeadline());
        tarefa.setPrioridade(Prioridade.porId(tarefaDTO.getPrioridade()));
        tarefa.setResponsavel(funcionarioService.porId(tarefaDTO.getIdFuncionario()));

        return tarefaRepository.save(tarefa);
    }

    public Boolean removerTarefa(Long id) {
        Tarefa tarefa = porId(id);
        tarefaRepository.delete(tarefa);
        return true;
    }
}
