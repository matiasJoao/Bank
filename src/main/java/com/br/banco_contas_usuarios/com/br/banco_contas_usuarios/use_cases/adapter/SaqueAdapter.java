package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.adapter;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Saque;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.repositorys.SaqueRepository;
import org.springframework.stereotype.Component;

@Component
public class SaqueAdapter {

    private final SaqueRepository saqueRepository;

    public SaqueAdapter(SaqueRepository saqueRepository) {
        this.saqueRepository = saqueRepository;
    }

    public Saque save (Saque saque){
        return saqueRepository.save(saque);
    }
}
