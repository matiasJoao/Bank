package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.utils;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Saque;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.adapter.ContaAdapter;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.adapter.SaqueAdapter;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.SaqueDTO;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

@Component
public class SaqueUtil {

    private final ContaAdapter contaAdapter;
    private final SaqueAdapter saqueAdapter;

    public SaqueUtil(ContaAdapter contaAdapter, SaqueAdapter saqueAdapter) {
        this.contaAdapter = contaAdapter;
        this.saqueAdapter = saqueAdapter;
    }

    public SaqueDTO saqueConta(SaqueDTO saqueDTO){
        var conta = contaAdapter.findByDocument(saqueDTO.getDocument());
        if(conta.isEmpty()){
            throw new RuntimeException("error conta nao econtrada");
        }
        if(Objects.equals(conta.get().getAgency(), saqueDTO.getAgencia()) && Objects.equals(conta.get().getNumber_account(), saqueDTO.getNumeroConta() )){
            if(conta.get().getBalance() < saqueDTO.getValorSaque()){
                throw  new RuntimeException("Valor do saque invalido, Saldo insuficiente");
            }
            var saldoAntigo = conta.get().getBalance();
            conta.get().setBalance(conta.get().getBalance() - saqueDTO.getValorSaque());
            var contaAtt = contaAdapter.saveConta(conta.get());
            var saque = Saque.builder().valorSaque(saqueDTO.getValorSaque())
                    .documentConta(contaAtt.getDocument())
                    .agencia(contaAtt.getAgency())
                    .idConta(contaAtt.getId())
                    .numeroConta(contaAtt.getNumber_account())
                    .saldoAntigo(saldoAntigo)
                    .saldoNovo(contaAtt.getBalance())
                    .idUsuario(contaAtt.getId_document())
                    .build();
            var resSaque =  saqueAdapter.save(saque);

            var saqueRetorno = SaqueDTO.builder().valorSaque(resSaque.getValorSaque())
                    .agencia(resSaque.getAgencia())
                    .numeroConta(resSaque.getNumeroConta())
                    .saldoAntigo(saldoAntigo)
                    .saldoNovo(resSaque.getSaldoNovo())
                    .document(saqueDTO.getDocument())
                    .date(new Date())
                    .build();
            return saqueRetorno;

        }
        throw new RuntimeException("error no saqueutil");

    }
}
