package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.controller;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.TransacoesDTO;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.TransferenciaDTO;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.services.TransferenciasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/transacao")
public class TranferenciasController {
    private final TransferenciasService transferenciasService;

    public TranferenciasController(TransferenciasService transferenciasService){
        this.transferenciasService = transferenciasService;
    }
    @PostMapping
    @RequestMapping("/transferencia")
    public ResponseEntity transferenciaEntreContas(@RequestBody TransacoesDTO transacoesDTO){
        var res =  transferenciasService.save(transacoesDTO);
        var body = TransferenciaDTO.builder().numberAccountContaDestino(res.getNumeroContaDestino())
                .numberAccountContaOrigem(res.getNumeroContaOrigem())
                .agencyContaDestino(res.getAgenciaContaDestino())
                .agencyContaOrigem(res.getNumeroContaDestino())
                .tipoTransferencia(res.getTipoTransferencia())
                .valorTransferencia(res.getValorTransferencia())
                .date(new Date()).build();
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }
}
