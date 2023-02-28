package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.controller;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Transferencias;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.adapter.TransferenciasAdapter;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.DepositoDTO;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.services.ContaService;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.CreateAccountDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/conta")
public class ContaController {
   private final ContaService contaService;
   private final TransferenciasAdapter transacoesAdapter;

    public ContaController(ContaService contaService, TransferenciasAdapter transacoesAdapter) {
       this.contaService = contaService;
       this.transacoesAdapter = transacoesAdapter;
    }

    @PostMapping
    @RequestMapping("/cadastro")
    public ResponseEntity createNewAccount(@RequestBody CreateAccountDTO createAccountDTO){
        var conta = contaService.gerarNovaConta(createAccountDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(conta);
    }


}
