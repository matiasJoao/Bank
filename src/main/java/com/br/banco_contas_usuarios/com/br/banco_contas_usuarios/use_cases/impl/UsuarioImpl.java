package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.impl;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Conta;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.TipoConta;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Usuario;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.repositorys.EnderecoRepository;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.repositorys.UsuarioRepository;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.ContaService;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.UsuarioService;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.ReturnDTO;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.UUID;
@Service
public class UsuarioImpl implements UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    ContaImpl conta;

    @Override
    public ReturnDTO save(UsuarioDTO usuarioDTO, Long tipoConta) {
        Integer agency = 1234;
        int min = 1000;
        int max = 5000;
        int number_random_account = (int)Math.floor(Math.random() * (max - min + 1) + min);
        Conta conta1 = new Conta();
        conta1.setVerify_digit(9);
        conta1.setDocument(usuarioDTO.getDocument());
        conta1.setBalance(0.0);
        conta1.setAgency(agency);
        conta1.setNumber_account(number_random_account);
        conta1.setType_account(TipoConta.builder().id(tipoConta).build());
        conta1.setId_document(usuarioDTO.getDocument());
       var conta2 = conta.save(conta1);
        var adress =  enderecoRepository.saveAndFlush(usuarioDTO.getEndereco());
        Usuario usuario = Usuario.builder().document(usuarioDTO.getDocument()).endereco(adress)
                .name(usuarioDTO.getName()).number(usuarioDTO.getNumber()).build();
        Usuario usuario1 = usuarioRepository.save(usuario);
        return ReturnDTO.builder().type_account(conta2.getType_account()).number_account(conta2.getNumber_account())
                .verify_digit(conta2.getVerify_digit()).balance(conta2.getBalance())
                .agency(conta2.getAgency()).endereco(usuarioDTO.getEndereco()).name(usuarioDTO.getName()).build();
    }
    @Override
    public Usuario findById(UUID uuid){
        return usuarioRepository.findById(uuid).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario Não Encontrado"));
    }

}
