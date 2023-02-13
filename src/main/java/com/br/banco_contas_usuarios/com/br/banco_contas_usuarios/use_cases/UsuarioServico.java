package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Usuario;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioServico {

    Usuario save(Usuario usuario);

   Usuario findById(UUID uuid);
}
