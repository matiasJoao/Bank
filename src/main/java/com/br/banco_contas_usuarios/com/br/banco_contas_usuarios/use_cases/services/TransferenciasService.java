package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.services;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Transferencias;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.TransacoesDTO;


public interface TransferenciasService {

    Transferencias save (TransacoesDTO transacoesDTO);

}
