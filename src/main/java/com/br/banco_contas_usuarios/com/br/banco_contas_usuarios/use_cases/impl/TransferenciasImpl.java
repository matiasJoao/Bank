package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.impl;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Transferencias;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.adapter.TransferenciasAdapter;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.TransacoesDTO;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.services.TransferenciasService;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.utils.TransferenciasUtil;
import org.springframework.stereotype.Service;

@Service
public class TransferenciasImpl implements TransferenciasService {


    private final TransferenciasAdapter transferenciasAdapter;
    private final TransferenciasUtil transferenciasUtil;

    public TransferenciasImpl(TransferenciasAdapter transferenciasAdapter, TransferenciasUtil transferenciasUtil){
        this.transferenciasAdapter = transferenciasAdapter;
        this.transferenciasUtil = transferenciasUtil;
    }
    @Override
    public Transferencias save(TransacoesDTO transacoesDTO) {
        var res = transferenciasUtil.transferenciasEntreContas(transacoesDTO);
        return transferenciasAdapter.save(res);
    }
}
