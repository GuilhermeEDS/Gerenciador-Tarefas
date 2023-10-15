package com.empresa.tarefas.controller;

import com.empresa.tarefas.dto.FuncionarioDTO;
import com.empresa.tarefas.dto.TarefaDTO;
import com.empresa.tarefas.entity.Funcionario;
import com.empresa.tarefas.entity.Tarefa;
import com.empresa.tarefas.enumeration.Prioridade;
import com.empresa.tarefas.enumeration.Situacao;
import com.empresa.tarefas.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.BindingResult;
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

    @GetMapping("/tarefa/situacao")
    public Situacao[] getTodasSituacao() {
        return Situacao.values();
    }

    @GetMapping("/tarefa/buscar")
    public List<Tarefa> getFuncionario(@RequestParam(required = false, defaultValue = "0") Long numero, @RequestParam(required = false, defaultValue = "%") String tituloDes, @RequestParam(required = false, defaultValue = "%") String responsavel, @RequestParam(required = false, defaultValue = "0") Integer situacao) {
        return (List<Tarefa>) tarefaService.buscarTarefa(numero, tituloDes.toLowerCase(), responsavel.toLowerCase(), Situacao.values()[situacao]);
    }

    @GetMapping("/tarefa/{idTarefa}")
    public Tarefa getTarefa(@PathVariable Long idTarefa) {
        return tarefaService.porId(idTarefa);
    }

    @PostMapping("/tarefa")
    public ResponseEntity<?> criarTarefa(@RequestBody @Valid TarefaDTO tarefaDTO, @NonNull BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.ok(result.getAllErrors());
        }
        tarefaService.criarTarefa(tarefaDTO);
        return ResponseEntity.ok(result.getAllErrors());
    }

    @PostMapping("/tarefa/{idTarefa}")
    public ResponseEntity<?> editarTarefa(@RequestBody @Valid TarefaDTO tarefaDTO, @NonNull BindingResult result, @PathVariable Long idTarefa) {
        if (result.hasErrors()) {
            result.getAllErrors().forEach(error ->{
                System.out.println(error.getDefaultMessage());
            });
            return ResponseEntity.ok(result.getAllErrors());
        }
        tarefaService.atualizarTarefa(tarefaDTO, idTarefa);
        return ResponseEntity.ok(result.getAllErrors());
    }
    @DeleteMapping("/tarefa/remover/{idTarefa}")
    public void deletarTarefa(@PathVariable Long idTarefa) {
        tarefaService.removerTarefa(idTarefa);
    }

    @PostMapping("/tarefa/concluir/{idTarefa}")
    public void concluir(@PathVariable Long idTarefa) {
        tarefaService.concluirTarefa(idTarefa);
    }

}
