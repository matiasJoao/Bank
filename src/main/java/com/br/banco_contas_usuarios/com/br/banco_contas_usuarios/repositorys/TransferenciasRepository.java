package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.repositorys;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Deposito;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Transferencias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferenciasRepository extends JpaRepository<Transferencias, String> {
    List<Transferencias> findByIdUsuario(String idUsuario);
    List<Transferencias> findByIdContaDestino(String idContaDestino);
}
