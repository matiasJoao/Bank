package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Conta;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.CreateAccountDTO;
import org.springframework.stereotype.Service;



public interface ContaService {
    Conta save(Conta conta);
    Conta gerarNovaConta (CreateAccountDTO createAccountDTO);
}
