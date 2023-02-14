package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.impl;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Usuario;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.repositorys.UsuarioRepository;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.UUID;

public class UsuarioImpl implements UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ContaImpl conta;

    @Override
    public Usuario save(Usuario usuario) {
        Integer agency = 1234;
        int min = 1000;
        int max = 5000;
        int number_random_account = (int)Math.floor(Math.random() * (max - min + 1) + min);
        usuario.getContas().get(0).setNumber_account(number_random_account);
        usuario.getContas().get(0).setCpf(usuario.getCpf());
        usuario.getContas().get(0).setVerify_digit(9);
        usuario.getContas().get(0).setBalance(0.0);
        usuario.getContas().get(0).setAgency(agency);
        Usuario userDto =   usuarioRepository.save(usuario);
        return userDto;

    }
    @Override
    public Usuario findById(UUID uuid){
        return usuarioRepository.findById(uuid).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario Não Encontrado"));
    }
    


}
