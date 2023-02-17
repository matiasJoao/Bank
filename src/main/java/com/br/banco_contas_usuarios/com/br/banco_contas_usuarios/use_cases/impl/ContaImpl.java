package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.impl;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Conta;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.repositorys.ContaRepository;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaImpl implements ContaService {
    @Autowired
    ContaRepository contaRepository;
    @Override
    public Conta save(Conta conta) {
       return   contaRepository.save(conta);
    }
}
