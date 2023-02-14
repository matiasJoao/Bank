package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.repositorys;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContaRepository extends JpaRepository<UUID, Conta> {
}
