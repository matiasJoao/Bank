package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.impl;


import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Endereco;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Usuario;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.repositorys.EnderecoRepository;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.repositorys.UsuarioRepository;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.UsuarioService;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.ReturnDTO;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.UsuarioDTO;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.utils.GerarContaUtil;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.utils.SaveEnderecoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class UsuarioImpl implements UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    GerarContaUtil gerarContaUtil = new GerarContaUtil();
    SaveEnderecoUtil saveEnderecoUtil = new SaveEnderecoUtil();

    @Override
    public ReturnDTO save(UsuarioDTO usuarioDTO, Long tipoConta) {
        Usuario usuario = Usuario.builder().document(usuarioDTO.getDocument())
                .name(usuarioDTO.getName()).number(usuarioDTO.getNumber()).build();
        Usuario usuario1 = usuarioRepository.save(usuario);
        var conta = gerarContaUtil.gerarFirstConta(usuario1, tipoConta);
        var adress = saveEnderecoUtil.saveEndereco(usuario1, usuarioDTO);
        return ReturnDTO.builder().type_account(conta.getType_account().getType_account()).number_account(conta.getNumber_account())
                .verify_digit(conta.getVerify_digit()).balance(conta.getBalance())
                .agency(conta.getAgency()).endereco(adress).name(usuarioDTO.getName()).build();
    }
   @Override
   public Usuario findById(String id){
       return usuarioRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario Não Encontrado"));
   }

}
