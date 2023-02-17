package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.controller;


import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Usuario;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.ReturnDTO;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.UsuarioDTO;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.impl.UsuarioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UsuarioImpl usuario;

    @PostMapping
    @RequestMapping("/cadastro/tipoConta/{tipoConta}")
    public ResponseEntity save(@RequestBody UsuarioDTO usuarioDTO, @PathVariable("tipoConta") Long tipoConta){
        ReturnDTO res = usuario.save(usuarioDTO, tipoConta);
        return  ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

}
