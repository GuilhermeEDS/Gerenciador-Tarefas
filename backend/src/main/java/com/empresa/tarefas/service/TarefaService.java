package com.empresa.tarefas.service;

import com.empresa.tarefas.arq.ValidacaoEntidadeException;
import com.empresa.tarefas.dto.TarefaDTO;
import com.empresa.tarefas.entity.Funcionario;
import com.empresa.tarefas.entity.Tarefa;
import com.empresa.tarefas.enumeration.Prioridade;
import com.empresa.tarefas.enumeration.Situacao;
import com.empresa.tarefas.repository.FuncionarioRepository;
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

    @Autowired
    FuncionarioRepository funcionarioRepository;

    public Iterable<Tarefa> listarTarefas() {
        return tarefaRepository.findAll();
    }

    public Tarefa porId(Long id) throws ValidacaoEntidadeException{
        Optional<Tarefa> tarefa = tarefaRepository.findById(id);
        if (tarefa.isEmpty()) {
            throw new ValidacaoEntidadeException("Tarefa não cadastrada");
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
        Funcionario funcionario = funcionarioService.porId(tarefaDTO.getIdFuncionario());

        tarefa.setTitulo(tarefaDTO.getTitulo());
        tarefa.setDescricao(tarefaDTO.getDescricao());
        tarefa.setDeadline(tarefaDTO.getDeadline());
        tarefa.setPrioridade(Prioridade.porId(tarefaDTO.getPrioridade()));
        tarefa.setResponsavel(funcionario);
        funcionario.getTarefas().add(tarefa);

        funcionarioRepository.save(funcionario);
        return tarefaRepository.save(tarefa);
    }

    public void removerTarefa(Long id) {
        Tarefa tarefa = porId(id);
        tarefaRepository.delete(tarefa);
    }

    public void concluirTarefa(Long idTarefa) {
        Tarefa tarefa = porId(idTarefa);
        tarefa.setSituacao(Situacao.CONCLUIDA);
        tarefaRepository.save(tarefa);
    }

    public Object buscarTarefa(Long numero, String tituloDes, String responsavel, Situacao situacao) {
        return tarefaRepository.searchBy(numero, tituloDes, responsavel, situacao);
    }
}
