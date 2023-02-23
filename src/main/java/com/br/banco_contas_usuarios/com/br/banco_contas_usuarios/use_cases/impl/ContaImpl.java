package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.impl;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Conta;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.repositorys.ContaRepository;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.ContaService;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.CreateAccountDTO;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.utils.GerarContaUtil;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.utils.PegarUsuarioPorIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaImpl implements ContaService {
    @Autowired
    ContaRepository contaRepository;
    PegarUsuarioPorIdUtil pegarUsuarioPorIdUtil = new PegarUsuarioPorIdUtil();
    GerarContaUtil gerarContaUtil = new GerarContaUtil();
    @Override
    public Conta save(Conta conta) {
       return   contaRepository.save(conta);
    }

    @Override
    public Conta gerarNovaConta(CreateAccountDTO createAccountDTO) {
        pegarUsuarioPorIdUtil.idUser(createAccountDTO.getIdUsuario());
       return   gerarContaUtil.gerarNewConta(createAccountDTO);
    }
}
