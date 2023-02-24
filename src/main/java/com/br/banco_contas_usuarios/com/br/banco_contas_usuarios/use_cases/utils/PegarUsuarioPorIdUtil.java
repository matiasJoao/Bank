package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.utils;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Usuario;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.adapter.UsuarioAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PegarUsuarioPorIdUtil {


    private final UsuarioAdapter usuarioAdapter;

    public PegarUsuarioPorIdUtil(UsuarioAdapter usuarioAdapter) {
        this.usuarioAdapter = usuarioAdapter;
    }


    public Optional<Usuario> idUser (String id){
        var res = usuarioAdapter.findById(id);
        return res;
    }
}
