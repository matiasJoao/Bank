package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.impl;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Deposito;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.adapter.DepositoAdapter;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.DepositoDTO;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.services.DepositoService;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.utils.DepositoUtil;
import org.springframework.stereotype.Service;

@Service
public class DepositoImpl implements DepositoService {

    private final DepositoUtil depositoUtil;
    private final DepositoAdapter depositoAdapter;

    public DepositoImpl(DepositoUtil depositoUtil, DepositoAdapter depositoAdapter) {
        this.depositoUtil = depositoUtil;
        this.depositoAdapter = depositoAdapter;
    }

    @Override
    public DepositoDTO save(DepositoDTO depositoDTO) {
        var res = depositoUtil.deposito(depositoDTO);
        System.out.println(res);
        var deposito = Deposito.builder().valorDeposito(res.getDepositoValor())
                .documentConta(res.getDocument())
                .agencia(res.getAgency())
                .saldoAntigo(res.getSaldoAnterior())
                .idUsuario(res.getIdUsuario())
                .numeroConta(res.getNumber_account())
                .saldoNovo(res.getNovoSaldo())
                .idConta(res.getIdConta())
                .build();
        depositoAdapter.save(deposito);
        return res;


    }
}
