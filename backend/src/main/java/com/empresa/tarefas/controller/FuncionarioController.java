package com.empresa.tarefas.controller;

import com.empresa.tarefas.config.MensagemLogin;
import com.empresa.tarefas.dto.FuncionarioDTO;
import com.empresa.tarefas.dto.LoginDTO;
import com.empresa.tarefas.entity.Funcionario;
import com.empresa.tarefas.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
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

    @PostMapping("/funcionario")
    public Funcionario criarFuncionario(@RequestBody FuncionarioDTO funcionarioDTO) {
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

    @PostMapping("/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO)
    {
        MensagemLogin resposta = funcionarioService.loginFuncionario(loginDTO);
        return ResponseEntity.ok(resposta);
    }

}
