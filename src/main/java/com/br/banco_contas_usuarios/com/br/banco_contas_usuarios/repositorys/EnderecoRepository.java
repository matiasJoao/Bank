package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.repositorys;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EnderecoRepository extends JpaRepository<Endereco, String> {

}
