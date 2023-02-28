package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.utils;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.exception.exception_class.CpfExceptionError;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.adapter.ContaAdapter;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.adapter.DepositoAdapter;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.DepositoDTO;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

@Component
public class DepositoUtil {

    private final ContaAdapter contaAdapter;

    private final DepositoAdapter depositoAdapter;

    public DepositoUtil(ContaAdapter contaAdapter, DepositoAdapter depositoAdapter) {
        this.contaAdapter = contaAdapter;

        this.depositoAdapter = depositoAdapter;
    }


    public DepositoDTO deposito(DepositoDTO depositoDTO){
      var document = depositoDTO.getDocument();
     var res = contaAdapter.findByDocument(document);
      if(res.isEmpty()){
          throw new CpfExceptionError();
      }
      if(Objects.equals(res.get().getNumber_account(), depositoDTO.getNumber_account()) && Objects.equals(res.get().getAgency(), depositoDTO.getAgency())){
          var saldoAnterior = res.get().getBalance();
          var saldoNovo = res.get().getBalance().doubleValue() + depositoDTO.getDepositoValor();
          res.get().setBalance(saldoNovo);
          contaAdapter.saveConta(res.get());
          var dep = DepositoDTO.builder().depositoValor(depositoDTO.getDepositoValor())
                  .date(new Date())
                  .agency(res.get().getAgency())
                  .number_account(res.get().getNumber_account())
                  .document(res.get().getDocument())
                  .novoSaldo(res.get().getBalance())
                  .saldoAnterior(saldoAnterior)
                  .idUsuario(res.get().getId_document())
                  .idConta(res.get().getId())
                  .build();

          return dep;
      }
    throw new RuntimeException("error");

    }
}
