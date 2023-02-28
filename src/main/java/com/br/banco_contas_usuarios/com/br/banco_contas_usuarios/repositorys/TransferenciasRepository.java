package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.repositorys;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Transferencias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferenciasRepository extends JpaRepository<Transferencias, String> {
}
