package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.adapter;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Deposito;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Transferencias;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.repositorys.TransferenciasRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransferenciasAdapter {
    private final TransferenciasRepository transferenciasRepository;
    public TransferenciasAdapter(TransferenciasRepository transferenciasRepository){
        this.transferenciasRepository = transferenciasRepository;
    }

    public Transferencias save (Transferencias transacoes){
        return transferenciasRepository.save(transacoes);
    }

    public List<Transferencias> findByIdUsuario(String idUsuario){
        return transferenciasRepository.findByIdUsuario(idUsuario);
    }
    public List<Transferencias> findByIdContaDestino (String idContaDestino){
        return transferenciasRepository.findByIdContaDestino(idContaDestino);
    }
}
