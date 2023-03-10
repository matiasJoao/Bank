package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.adapter;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Conta;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.repositorys.ContaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ContaAdapter {

    private final ContaRepository contaRepository;
    public ContaAdapter(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public Conta saveConta (Conta conta){
        return contaRepository.save(conta);
    }
    public Optional<Conta> findById(String id){
        return contaRepository.findById(id);
    }
    public Optional<Conta> findByDocument(String document){
        return contaRepository.findByDocument(document);
    }

}
