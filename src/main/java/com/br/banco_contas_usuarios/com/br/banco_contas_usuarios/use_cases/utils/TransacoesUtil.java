package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.utils;


import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Transacoes;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.adapter.ContaAdapter;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.TransacoesDTO;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.impl.ContaImpl;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TransacoesUtil {


    private final ContaImpl contaImpl;
    private final ContaAdapter contaAdapter;

    public TransacoesUtil(ContaImpl contaImpl, ContaAdapter contaAdapter) {
        this.contaImpl = contaImpl;
        this.contaAdapter = contaAdapter;
    }

    public Transacoes verificarContaEalterarSaldo(TransacoesDTO transacoesDTO) {
        var contaOrigem = contaAdapter.findByDocument(transacoesDTO.getDocumentOrigem());
        var contaDestino = contaAdapter.findByDocument(transacoesDTO.getDocumentDestino());
        Date date = new Date();

        Double oldBalanceOrigem = contaOrigem.get().getBalance();

        Double balanceDestino = contaDestino.get().getBalance().doubleValue() + transacoesDTO.getValorTransferencia().doubleValue();
        Double balanceOrigem = contaOrigem.get().getBalance().doubleValue() - transacoesDTO.getValorTransferencia().doubleValue();
        contaDestino.get().setBalance(balanceDestino);
        contaOrigem.get().setBalance(balanceOrigem);
        contaImpl.save(contaDestino.get());
        var saldoNovo = contaImpl.save(contaOrigem.get());

        return Transacoes.builder().date(date).idContaOrigem(contaOrigem.get().getId())
                .idUsuario(contaOrigem.get().getId_document())
                .idContaDestino(contaDestino.get().getId())
                .tipoTransferencia(transacoesDTO.getTipoTransferencia())
                .valorTransferencia(transacoesDTO.getValorTransferencia())
                .agencyContaDestino(contaDestino.get().getAgency())
                .numberAccountContaDestino(contaDestino.get().getNumber_account())
                .agencyContaOrigem(contaOrigem.get().getAgency())
                .numberAccountContaOrigem(contaOrigem.get().getNumber_account())
                .saldoAntigo(oldBalanceOrigem)
                .saldoNovo(saldoNovo.getBalance())
                .tipoTransacao("Transferencia")
                .build();
    }

}
