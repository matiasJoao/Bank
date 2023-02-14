package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.controller;


import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Usuario;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.impl.UsuarioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UsuarioImpl usuarioimpl;

    @PostMapping
    public ResponseEntity save(@RequestBody Usuario usuario){
     Usuario usuario1 =   usuarioimpl.save(usuario);
        return ResponseEntity.status(HttpStatus.OK).body(usuario1);
    }
}
