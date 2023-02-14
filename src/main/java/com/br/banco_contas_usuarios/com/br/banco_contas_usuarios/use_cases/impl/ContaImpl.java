package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.impl;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Conta;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.ContaService;
import org.springframework.beans.factory.annotation.Autowired;

public class ContaImpl implements ContaService {
    @Autowired
    ContaService contaService;
    @Override
    public Conta save(Conta conta) {
        return contaService.save(conta);
    }
}
