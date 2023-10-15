package com.empresa.tarefas.controller;

import com.empresa.tarefas.dto.FuncionarioDTO;
import com.empresa.tarefas.entity.Funcionario;
import com.empresa.tarefas.service.FuncionarioService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @GetMapping("/funcionario")
    public List<Funcionario> getTodosFuncionarios() {
        return (List<Funcionario>) funcionarioService.listarFuncionarios();
    }

    @GetMapping("/funcionario/buscar")
    public List<Funcionario> getFuncionario(@RequestParam(required = false, defaultValue = "%") String nome, @RequestParam(required = false, defaultValue = "%") String cpf) {
        return (List<Funcionario>) funcionarioService.buscarFuncionario(nome.toLowerCase(), cpf.toLowerCase());
    }

    @GetMapping("/funcionario/{idFuncionario}")
    public Funcionario getFuncionario(@PathVariable Long idFuncionario) {
        return funcionarioService.porId(idFuncionario);
    }

    @PostMapping("/funcionario")
    public ResponseEntity<?> criarFuncionario(@RequestBody @Valid FuncionarioDTO funcionarioDTO, @NonNull BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.ok(result.getAllErrors());
        }
        funcionarioService.criarFuncionario(funcionarioDTO);
        return ResponseEntity.ok(result.getAllErrors());
    }

    @PostMapping("/funcionario/{idFuncionario}")
    public ResponseEntity<?> editarFuncionario(@RequestBody @Valid FuncionarioDTO funcionarioDTO, @NonNull BindingResult result, @PathVariable Long idFuncionario) {
        if (result.hasErrors()) {
            result.getAllErrors().forEach(error ->{
                System.out.println(error.getDefaultMessage());
            });
            return ResponseEntity.ok(result.getAllErrors());
        }
        funcionarioService.atualizarFuncionario(funcionarioDTO, idFuncionario);
        return ResponseEntity.ok(result.getAllErrors());
    }

}
