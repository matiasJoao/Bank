package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.services;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Conta;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.CreateAccountDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface ContaService {
    Conta save(Conta conta);
    Conta gerarNovaConta (CreateAccountDTO createAccountDTO);

    Optional<Conta> findById(String id);
}
