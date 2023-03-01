package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.services;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Saque;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.SaqueDTO;

public interface SaqueService {

    SaqueDTO save (SaqueDTO saque);
}
