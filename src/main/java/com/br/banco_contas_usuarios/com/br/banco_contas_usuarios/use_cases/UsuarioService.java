package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Usuario;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.ReturnDTO;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.UsuarioDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

public interface UsuarioService {

    ReturnDTO save(UsuarioDTO usuarioDTO, Long tipoConta);
    Usuario findById(String id);

}
