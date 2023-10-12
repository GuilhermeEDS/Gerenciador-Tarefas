package com.empresa.tarefas.controller;

import com.empresa.tarefas.dto.FuncionarioDTO;
import com.empresa.tarefas.dto.TarefaDTO;
import com.empresa.tarefas.entity.Funcionario;
import com.empresa.tarefas.entity.Tarefa;
import com.empresa.tarefas.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TarefaController {

    @Autowired
    TarefaService tarefaService;

    @RequestMapping("/tarefa")
    public List<Tarefa> getTodasTarefas() {
        return (List<Tarefa>) tarefaService.listarTarefas();
    }

    @RequestMapping("/tarefa/{idTarefa}")
    public Tarefa getTarefa(@PathVariable Long idFuncionario) {
        return tarefaService.porId(idFuncionario);
    }

    @RequestMapping(value = "/tarefa" , method = RequestMethod.POST, consumes = { "multipart/form-data" })
    public Tarefa criarTarefa(@ModelAttribute TarefaDTO tarefaDTO) {
        return tarefaService.criarTarefa(tarefaDTO);
    }

    @RequestMapping(value = "/tarefa/{idTarefa}" , method = RequestMethod.POST, consumes = { "multipart/form-data" })
    public Tarefa editarTarefa(@ModelAttribute TarefaDTO tarefaDTO, @PathVariable Long idTarefa) {
        return tarefaService.atualizarTarefa(tarefaDTO, idTarefa);
    }

    @RequestMapping("/tarefa/remover/{idTarefa}")
    public String deletarTarefa(@PathVariable Long idTarefa) {
        if(tarefaService.removerTarefa(idTarefa)){
            return "Tarefa Removido";
        }
        return "Deu algum problema";
    }

}
