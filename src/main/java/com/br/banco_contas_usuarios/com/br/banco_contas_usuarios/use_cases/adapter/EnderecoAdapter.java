package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.adapter;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Endereco;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.repositorys.EnderecoRepository;
import org.springframework.stereotype.Component;

@Component
public class EnderecoAdapter {

    private final EnderecoRepository enderecoRepository;

    public EnderecoAdapter(EnderecoRepository enderecoRepository){
        this.enderecoRepository = enderecoRepository;
    }

    public Endereco save(Endereco endereco){
        return enderecoRepository.save(endereco);
    }
}
