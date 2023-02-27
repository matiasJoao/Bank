package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.controller;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Transacoes;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.adapter.TransacoesAdapter;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.DepositoDTO;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.services.ContaService;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.CreateAccountDTO;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.services.TransacoesService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/conta")
public class ContaController {
   private final ContaService contaService;
   private final TransacoesAdapter transacoesAdapter;

    public ContaController(ContaService contaService, TransacoesAdapter transacoesAdapter) {
       this.contaService = contaService;
       this.transacoesAdapter = transacoesAdapter;
    }

    @PostMapping
    @RequestMapping("/cadastro")
    public ResponseEntity createNewAccount(@RequestBody CreateAccountDTO createAccountDTO){
        var conta = contaService.gerarNovaConta(createAccountDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(conta);
    }

    @PostMapping
    @RequestMapping("/deposito")
    public ResponseEntity deposito(@RequestBody DepositoDTO depositoDTO){
        var res = contaService.deposito(depositoDTO);
        var transacoes =  Transacoes.builder().date(new Date()).valorDeposito(res.getDepositoValor())
                .agency(res.getAgency())
                .numberAccount(res.getNumber_account())
                .saldoAntigo(res.getSaldoAnterior())
                .saldoNovo(res.getNovoSaldo())
                .idUsuario(res.getIdUsuario())
                .date(new Date()).build();
        transacoesAdapter.save(transacoes);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

}
