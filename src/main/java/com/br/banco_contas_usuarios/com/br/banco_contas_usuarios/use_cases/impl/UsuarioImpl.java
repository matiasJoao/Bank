package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.impl;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Usuario;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.repositorys.UsuarioRepository;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

public class UsuarioImpl implements UsuarioServico {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public Usuario save(Usuario usuario) {
       return usuarioRepository.save(usuario);
    }
    @Override
    public Usuario findById(UUID uuid){
        return usuarioRepository.findById(uuid).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario Não Encontrado"));
    }


}
