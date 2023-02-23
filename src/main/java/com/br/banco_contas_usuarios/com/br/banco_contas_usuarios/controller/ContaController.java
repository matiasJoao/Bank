package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.controller;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.services.ContaService;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.CreateAccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conta")
public class ContaController {
    @Autowired
    ContaService contaService;
    @PostMapping
    @RequestMapping("/cadastro/conta")
    public ResponseEntity createNewAccount(@RequestBody CreateAccountDTO createAccountDTO){
        var conta = contaService.gerarNovaConta(createAccountDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(conta);
    }
}
