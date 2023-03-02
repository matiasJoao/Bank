package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.repositorys;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Deposito;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Saque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaqueRepository extends JpaRepository<Saque, String> {
    List<Saque> findByIdUsuario(String idUsuario);
}
