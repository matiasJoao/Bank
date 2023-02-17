package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Conta;
import org.springframework.stereotype.Service;



public interface ContaService {
    Conta save(Conta conta);
}
