package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.services;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Transacoes;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.TransacoesDTO;
import org.springframework.stereotype.Service;


public interface TransacoesService {

    Transacoes save (TransacoesDTO transacoesDTO);

}
