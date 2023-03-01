package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.impl;


import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.SaqueDTO;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.services.SaqueService;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.utils.SaqueUtil;
import org.springframework.stereotype.Service;

@Service
public class SaqueImpl implements SaqueService {

    private final SaqueUtil saqueUtil;

    public SaqueImpl(SaqueUtil saqueUtil) {
        this.saqueUtil = saqueUtil;
    }

    @Override
    public SaqueDTO save(SaqueDTO saque) {
        return saqueUtil.saqueConta(saque);
    }
}
