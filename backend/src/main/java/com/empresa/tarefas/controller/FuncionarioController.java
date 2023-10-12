package com.empresa.tarefas.controller;

import com.empresa.tarefas.dto.FuncionarioDTO;
import com.empresa.tarefas.entity.Funcionario;
import com.empresa.tarefas.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @RequestMapping("/funcionario")
    public List<Funcionario> getTodosFuncionarios() {
        return (List<Funcionario>) funcionarioService.listarFuncionarios();
    }

    @RequestMapping("/funcionario/{idFuncionario}")
    public Funcionario getFuncionario(@PathVariable Long idFuncionario) {
        return funcionarioService.porId(idFuncionario);
    }

    @RequestMapping(value = "/funcionario" , method = RequestMethod.POST, consumes = { "multipart/form-data" })
    public Funcionario criarFuncionario(@ModelAttribute FuncionarioDTO funcionarioDTO) {
        return funcionarioService.criarFuncionario(funcionarioDTO);
    }

    @RequestMapping(value = "/funcionario/{idFuncionario}" , method = RequestMethod.POST, consumes = { "multipart/form-data" })
    public Funcionario editarFuncionario(@ModelAttribute FuncionarioDTO funcionarioDTO, @PathVariable Long idFuncionario) {
        return funcionarioService.atualizarFuncionario(funcionarioDTO, idFuncionario);
    }

    @RequestMapping("/funcionario/remover/{idFuncionario}")
    public String deletarFuncionario(@PathVariable Long idFuncionario) {
        if(funcionarioService.removerFuncionario(idFuncionario)){
            return "Funcionario Removido";
        }
        return "Deu algum problema";
    }

}
