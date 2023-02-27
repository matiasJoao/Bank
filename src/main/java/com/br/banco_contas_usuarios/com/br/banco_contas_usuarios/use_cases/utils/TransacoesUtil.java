package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.utils;


import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Transacoes;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.TransacoesDTO;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.impl.ContaImpl;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class TransacoesUtil {


    private final ContaImpl contaImpl;

    public TransacoesUtil(ContaImpl contaImpl){
        this.contaImpl = contaImpl;
    }
    public Transacoes verificarContaEalterarSaldo(TransacoesDTO transacoesDTO){
        var idOrigem = contaImpl.findById(transacoesDTO.idContaOrigem);
        var idDestino = contaImpl.findById(transacoesDTO.idContaDestino);
        Date date = new Date();

        Double balanceDestino = idDestino.get().getBalance() + transacoesDTO.getValorTransferencia();
        Double balanceOrigem =  idOrigem.get().getBalance() - transacoesDTO.getValorTransferencia();
        idDestino.get().setBalance(balanceDestino);
        idOrigem.get().setBalance(balanceOrigem);
        contaImpl.save(idDestino.get());
        contaImpl.save(idOrigem.get());

        return Transacoes.builder().date(date).idContaOrigem(idOrigem.get().getId())
                .idContaDestino(idDestino.get().getId())
                .tipoTransferencia(transacoesDTO.getTipoTransferencia())
                .valorTransferencia(transacoesDTO.getValorTransferencia())
                .build();

    }

}
