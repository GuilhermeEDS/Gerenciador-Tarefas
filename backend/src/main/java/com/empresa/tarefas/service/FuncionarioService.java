package com.empresa.tarefas.service;

import com.empresa.tarefas.config.MensagemLogin;
import com.empresa.tarefas.dto.FuncionarioDTO;
import com.empresa.tarefas.dto.LoginDTO;
import com.empresa.tarefas.entity.Funcionario;
import com.empresa.tarefas.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

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
        funcionario.setSenha(passwordEncoder.encode(funcionarioDTO.getSenha()));
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

    public MensagemLogin loginFuncionario(LoginDTO loginDTO) {
        String msg = "";
        Optional<Funcionario> funcionario = funcionarioRepository.findByCpf(loginDTO.getCpf());
        if (funcionario.isPresent()) {
            String senha = loginDTO.getSenha();
            String senhaFuncionario = funcionario.get().getSenha();
            Boolean correto = passwordEncoder.matches(senha, senhaFuncionario);
            if (correto) {
                return new MensagemLogin("Logado com sucesso", true);
            } else {
                return new MensagemLogin("Senha incorreta", false);
            }        }else {
            return new MensagemLogin("Cpf não cadastrado", false);
        }
    }

}
