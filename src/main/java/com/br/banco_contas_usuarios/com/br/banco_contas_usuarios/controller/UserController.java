package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.controller;



import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.ReturnDTO;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.UsuarioDTO;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.impl.UsuarioImpl;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UsuarioService usuarioService;

    public UserController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping
    @RequestMapping("/cadastro")
    public ResponseEntity save(@RequestBody UsuarioDTO usuarioDTO){
        ReturnDTO res = usuarioService.save(usuarioDTO);
        return  ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

}
