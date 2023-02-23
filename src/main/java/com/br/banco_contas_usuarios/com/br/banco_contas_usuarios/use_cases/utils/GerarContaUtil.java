package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.utils;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Conta;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.TipoConta;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Usuario;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.CreateAccountDTO;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.impl.ContaImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class GerarContaUtil {


    Integer agency = 1234;
    int min = 1000;
    int max = 5000;
    int number_random_account = (int)Math.floor(Math.random() * (max - min + 1) + min);
    public Conta gerarFirstConta (Usuario usuario, Long tipoConta){

        Conta conta = new Conta();
        conta.setVerify_digit(9);
        conta.setDocument(usuario.getDocument());
        conta.setBalance(0.0);
        conta.setAgency(agency);
        conta.setNumber_account(number_random_account);
        conta.setType_account(TipoConta.builder().id(tipoConta).build());
        conta.setId_document(usuario.getId());
        return conta;
    }

    public Conta gerarNewConta(CreateAccountDTO createAccountDTO){
        var conta = Conta.builder().agency(agency).balance(0.0)
                .document(createAccountDTO.getDocumentAccount())
                .id_document(createAccountDTO.getIdUsuario())
                .number_account(number_random_account)
                .verify_digit(9)
                .type_account(createAccountDTO.getTipoConta())
                .build();
        return conta;
    }
}
