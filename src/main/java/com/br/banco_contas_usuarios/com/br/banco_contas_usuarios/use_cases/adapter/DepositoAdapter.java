package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.adapter;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Deposito;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.repositorys.DepositoRepository;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.DepositoDTO;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class DepositoAdapter {


    private final DepositoRepository depositoRepository;

    public DepositoAdapter(DepositoRepository depositoRepository){
        this.depositoRepository = depositoRepository;
    }

    public Deposito save(Deposito deposito){
        return  depositoRepository.save(deposito);

    }
    public List<Deposito> findByIdUsuario(String idUsuario){
        return depositoRepository.findByIdUsuario(idUsuario);
    }
}
