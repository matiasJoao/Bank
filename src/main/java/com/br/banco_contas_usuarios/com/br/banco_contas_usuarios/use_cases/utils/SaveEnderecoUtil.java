package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.utils;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Endereco;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Usuario;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.repositorys.EnderecoRepository;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;

public class SaveEnderecoUtil {

    @Autowired
    EnderecoRepository enderecoRepository;
    public Endereco saveEndereco(Usuario usuario, UsuarioDTO usuarioDTO){
       var adress = Endereco.builder().cep(usuarioDTO.getEndereco().getCep()).adress_number(usuarioDTO.getEndereco().getAdress_number())
                .complement(usuarioDTO.getEndereco().getComplement()).street_name(usuarioDTO.getEndereco().getStreet_name())
                .idUsuario(usuario.getId()).build();

        return enderecoRepository.save(adress);
    }
}