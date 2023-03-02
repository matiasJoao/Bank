package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.controller;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.SaqueDTO;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.services.SaqueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/saque")
public class SaqueController {

    private final SaqueService saqueService;
    private final KafkaTemplate<String, String> template;

    public SaqueController(SaqueService saqueService, KafkaTemplate<String, String> template) {
        this.saqueService = saqueService;
        this.template = template;
    }


    @PostMapping
    public ResponseEntity saque( @RequestBody SaqueDTO saqueDTO){
        var res = saqueService.save(saqueDTO);
        template.send("Transacoes", saqueDTO.getDocument());
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
}
