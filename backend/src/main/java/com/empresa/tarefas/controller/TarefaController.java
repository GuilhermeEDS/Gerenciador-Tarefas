package com.empresa.tarefas.controller;

import com.empresa.tarefas.dto.TarefaDTO;
import com.empresa.tarefas.entity.Tarefa;
import com.empresa.tarefas.enumeration.Prioridade;
import com.empresa.tarefas.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class TarefaController {

    @Autowired
    TarefaService tarefaService;

    @GetMapping("/tarefa")
    public List<Tarefa> getTodasTarefas() {
        return (List<Tarefa>) tarefaService.listarTarefas();
    }

    @GetMapping("/tarefa/prioridade")
    public Prioridade[] getTodasPrioridades() {
        return Prioridade.values();
    }

    @GetMapping("/tarefa/{idTarefa}")
    public Tarefa getTarefa(@PathVariable Long idTarefa) {
        return tarefaService.porId(idTarefa);
    }

    @PostMapping("/tarefa")
    public Tarefa criarTarefa(@RequestBody TarefaDTO tarefaDTO) {
        return tarefaService.criarTarefa(tarefaDTO);
    }

    @PostMapping("/tarefa/{idTarefa}")
    public Tarefa editarTarefa(@RequestBody TarefaDTO tarefaDTO, @PathVariable Long idTarefa) {
        return tarefaService.atualizarTarefa(tarefaDTO, idTarefa);
    }

    @DeleteMapping("/tarefa/remover/{idTarefa}")
    public void deletarTarefa(@PathVariable Long idTarefa) {
        tarefaService.removerTarefa(idTarefa);
    }

}
