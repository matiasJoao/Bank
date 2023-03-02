package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.utils;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Deposito;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Saque;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Transferencias;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.adapter.*;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.ExtratoDTO;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.UsuarioDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExtratoUtil {
    private final SaqueAdapter saqueAdapter;
    private final DepositoAdapter depositoAdapter;
    private final TransferenciasAdapter transferenciasAdapter;
    private final UsuarioAdapter usuarioAdapter;
    private final ContaAdapter contaAdapter;

    public ExtratoUtil(SaqueAdapter saqueAdapter, DepositoAdapter depositoAdapter, TransferenciasAdapter transferenciasAdapter, UsuarioAdapter usuarioAdapter, ContaAdapter contaAdapter) {
        this.saqueAdapter = saqueAdapter;
        this.depositoAdapter = depositoAdapter;
        this.transferenciasAdapter = transferenciasAdapter;
        this.usuarioAdapter = usuarioAdapter;
        this.contaAdapter = contaAdapter;
    }

    public ExtratoDTO extrato(UsuarioDTO usuarioDTO){
        var user = usuarioAdapter.findByDocument(usuarioDTO.getDocument());
        var conta = contaAdapter.findByDocument(usuarioDTO.getDocument());


        List<Deposito> depositos = depositoAdapter.findByIdUsuario(user.get().getId());
        List<Saque> saques = saqueAdapter.findByIdUsuario(user.get().getId());
        List<Transferencias> transferencias = transferenciasAdapter.findByIdUsuario(user.get().getId());
        List<Transferencias> transferenciasRecebidas = transferenciasAdapter.findByIdContaDestino(conta.get().getId());


        ExtratoDTO extrato = ExtratoDTO.builder()
                .depositos(depositos)
                .saques(saques)
                .transferenciasEnviadas(transferencias)
                .transferenciasRecebidas(transferenciasRecebidas)
                .build();
        return extrato;

    }
}
