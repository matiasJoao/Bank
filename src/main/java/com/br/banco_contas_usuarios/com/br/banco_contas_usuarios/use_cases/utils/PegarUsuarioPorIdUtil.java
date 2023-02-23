package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.utils;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

public class PegarUsuarioPorIdUtil {
    @Autowired
    UsuarioService usuarioService;
    public String idUser (String id){
        var res = usuarioService.findById(id);
        return res.getId();
    }
}
