package com.empresa.tarefas.service;

import com.empresa.tarefas.dto.FuncionarioDTO;
import com.empresa.tarefas.entity.Funcionario;
import com.empresa.tarefas.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    public Iterable<Funcionario> listarFuncionarios() {
        return  funcionarioRepository.findAll();
    }

    public Funcionario porId(Long id) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        if (funcionario.isEmpty()) {
            //adicionar Exception
            return null;
        }
        return funcionario.get();
    }

    public Funcionario criarFuncionario(FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = funcionarioDTO.toFuncionario();
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario atualizarFuncionario(FuncionarioDTO funcionarioDTO, Long id){
        Funcionario funcionario = porId(id);

        funcionario.setNome(funcionarioDTO.getNome());
        funcionario.setCpf(funcionarioDTO.getCpf());

        return funcionarioRepository.save(funcionario);
    }

    public Boolean removerFuncionario(Long id) {
        Funcionario funcionario = porId(id);
        funcionarioRepository.delete(funcionario);
        return true;
    }

    public Iterable<Funcionario> buscarFuncionario(String nome, String cpf){
        return funcionarioRepository.searchByNomeAndCpf(nome, cpf);
    }

}
