package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.controller;



import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.ExtratoDTO;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.ReturnDTO;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.UsuarioDTO;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.services.UsuarioService;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.utils.ExtratoUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UsuarioService usuarioService;
    private final ExtratoUtil extratoUtil;

    public UserController(UsuarioService usuarioService, ExtratoUtil extratoUtil){
        this.usuarioService = usuarioService;
        this.extratoUtil = extratoUtil;
    }

    @PostMapping
    @RequestMapping("/cadastro")
    public ResponseEntity save(@RequestBody UsuarioDTO usuarioDTO){
        ReturnDTO res = usuarioService.save(usuarioDTO);
        return  ResponseEntity.status(HttpStatus.CREATED).body(res);
    }
    @GetMapping
    @RequestMapping("/extrato")
    public ResponseEntity extrato(@RequestBody UsuarioDTO usuarioDTO){
        ExtratoDTO res = extratoUtil.extrato(usuarioDTO);
        return ResponseEntity.status(HttpStatus.OK).body(res);

    }

}
