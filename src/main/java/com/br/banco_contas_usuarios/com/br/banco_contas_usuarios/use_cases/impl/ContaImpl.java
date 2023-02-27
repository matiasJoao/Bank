package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.impl;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Conta;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.exception.exception_class.CpfExceptionError;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.adapter.ContaAdapter;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.CreateAccountDTO;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.services.ContaService;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.utils.GerarContaUtil;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.utils.ValidaCnpjUtil;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.utils.ValidaCpfUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
    public Optional<Conta> findById(String id) {
       return Optional.ofNullable(contaAdapter.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta Não Encontrada")));
    }
}
