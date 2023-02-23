package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.utils;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Conta;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.TipoConta;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Usuario;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.CreateAccountDTO;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.UsuarioDTO;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.impl.ContaImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class GerarContaUtil {

    @Autowired
    ContaImpl conta;
    Integer agency = 1234;
    int min = 1000;
    int max = 5000;
    int number_random_account = (int)Math.floor(Math.random() * (max - min + 1) + min);
    public Conta gerarFirstConta (Usuario usuario, Long tipoConta){

        Conta conta1 = new Conta();
        conta1.setVerify_digit(9);
        conta1.setDocument(usuario.getDocument());
        conta1.setBalance(0.0);
        conta1.setAgency(agency);
        conta1.setNumber_account(number_random_account);
        conta1.setType_account(TipoConta.builder().id(tipoConta).build());
        conta1.setId_document(usuario.getId());
        return conta.save(conta1);
    }

    public Conta gerarNewConta(CreateAccountDTO createAccountDTO){
        var conta2 = Conta.builder().agency(agency).balance(0.0)
                .document(createAccountDTO.getDocumentAccount())
                .id_document(createAccountDTO.getIdUsuario())
                .number_account(number_random_account)
                .verify_digit(9)
                .type_account(createAccountDTO.getTipoConta())
                .build();
        return conta.save(conta2);
    }
}
