package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.controller;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.SaqueDTO;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.services.SaqueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saque")
public class SaqueController {

    private final SaqueService saqueService;

    public SaqueController(SaqueService saqueService) {
        this.saqueService = saqueService;
    }

    @PostMapping
    public ResponseEntity saque( @RequestBody SaqueDTO saqueDTO){
        var res = saqueService.save(saqueDTO);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
}
