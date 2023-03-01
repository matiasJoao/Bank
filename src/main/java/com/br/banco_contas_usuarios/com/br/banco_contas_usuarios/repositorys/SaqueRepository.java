package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.repositorys;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Saque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaqueRepository extends JpaRepository<Saque, String> {
}
