package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.impl;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Transacoes;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.adapter.TransacoesAdapter;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.TransacoesDTO;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.services.TransacoesService;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.utils.TransacoesUtil;
import org.springframework.stereotype.Service;

@Service
public class TransacoesImpl implements TransacoesService {


    private final TransacoesAdapter transacoesAdapter;
    private final TransacoesUtil transacoesUtil;

    public TransacoesImpl(TransacoesAdapter transacoesAdapter, TransacoesUtil transacoesUtil){
        this.transacoesAdapter = transacoesAdapter;
        this.transacoesUtil = transacoesUtil;
    }
    @Override
    public Transacoes save(TransacoesDTO transacoesDTO) {
        var res = transacoesUtil.verificarContaEalterarSaldo(transacoesDTO);
        return transacoesAdapter.save(res);
    }
}
