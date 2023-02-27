package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.impl;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Conta;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.exception.exception_class.CpfExceptionError;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.adapter.ContaAdapter;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.CreateAccountDTO;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.DepositoDTO;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.services.ContaService;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.utils.GerarContaUtil;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.utils.ValidaCnpjUtil;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.utils.ValidaCpfUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Service
public class ContaImpl implements ContaService {
    private final GerarContaUtil gerarContaUtil;
    private final ContaAdapter contaAdapter;
    private final ValidaCpfUtil validaCpfUtil;
    private final ValidaCnpjUtil validaCnpjUtil;


    public ContaImpl(GerarContaUtil gerarContaUtil, ContaAdapter contaAdapter, ValidaCpfUtil validaCpfUtil, ValidaCnpjUtil validaCnpjUtil) {
        this.gerarContaUtil = gerarContaUtil;
        this.contaAdapter = contaAdapter;
        this.validaCpfUtil = validaCpfUtil;
        this.validaCnpjUtil = validaCnpjUtil;

    }

    @Override
    public Conta save(Conta conta) {
        return contaAdapter.saveConta(conta);
    }

    @Override
    public Conta gerarNovaConta(CreateAccountDTO createAccountDTO) {
        var cpf = validaCpfUtil.valida(createAccountDTO.getDocumentAccount().toString());
        var cnpj = validaCnpjUtil.valida(createAccountDTO.getDocumentAccount().toString());
        if(cpf){
            var res = gerarContaUtil.gerarNewConta(createAccountDTO);
            return save(res);
        } else if (cnpj) {
            var res = gerarContaUtil.gerarNewConta(createAccountDTO);
            return save(res);
        }
            throw new RuntimeException("error");
    }

    @Override
    public Conta findById(String id) {
       return contaAdapter.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta Não Encontrada"));
    }

    @Override
    public DepositoDTO deposito(DepositoDTO depositoDTO) {
      var res = contaAdapter.findByDocument(depositoDTO.getDocument());
      if(res.isEmpty()){
          throw new CpfExceptionError();
      }
      if(Objects.equals(res.get().getAgency(), depositoDTO.getAgency()) && Objects.equals(res.get().getNumber_account(), depositoDTO.getNumber_account())){
          Double oldBalance = res.get().getBalance();
          Double newBalance = res.get().getBalance() + depositoDTO.getDepositoValor();
          res.get().setBalance(newBalance);
          save(res.get());
          Date date = new Date();
          return DepositoDTO.builder().saldoAnterior(oldBalance)
                  .document(res.get().getDocument())
                  .agency(res.get().getAgency())
                  .number_account(res.get().getNumber_account())
                  .novoSaldo(newBalance)
                  .depositoValor(depositoDTO.getDepositoValor())
                  .date(date)
                  .idUsuario(res.get().getId_document())
                  .build();
      }
      throw new RuntimeException("error");

    }
}
