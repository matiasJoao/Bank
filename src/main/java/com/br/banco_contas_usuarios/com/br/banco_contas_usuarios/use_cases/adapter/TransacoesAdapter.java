package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.adapter;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Transacoes;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.repositorys.TransacoesRepository;
import org.springframework.stereotype.Component;

@Component
public class TransacoesAdapter {
    private final TransacoesRepository transacoesRepository;
    public TransacoesAdapter(TransacoesRepository transacoesRepository){
        this.transacoesRepository = transacoesRepository;
    }

    public Transacoes save (Transacoes transacoes){
        return transacoesRepository.save(transacoes);
    }
}
