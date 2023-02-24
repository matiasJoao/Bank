package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.adapter;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Usuario;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class UsuarioAdapter {
     @Autowired
     UsuarioRepository usuarioRepository;
    public Usuario saveUser (Usuario usuario){
        return  usuarioRepository.save(usuario);
    }

    public Optional<Usuario> findById (String id){
        return usuarioRepository.findById(id);
    }
}
