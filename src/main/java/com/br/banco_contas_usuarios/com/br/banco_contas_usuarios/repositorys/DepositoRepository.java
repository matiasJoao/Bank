package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.repositorys;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Deposito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositoRepository extends JpaRepository<Deposito, String> {
}
