package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.impl;


import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Usuario;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.repositorys.ContaRepository;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.repositorys.EnderecoRepository;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.repositorys.UsuarioRepository;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.services.UsuarioService;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.ReturnDTO;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.UsuarioDTO;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.utils.GerarContaUtil;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.utils.SaveEnderecoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuarioImpl implements UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ContaRepository contaRepository;
    @Autowired
    EnderecoRepository enderecoRepository;
    GerarContaUtil gerarContaUtil = new GerarContaUtil();
    SaveEnderecoUtil saveEnderecoUtil = new SaveEnderecoUtil();

    @Override
    public ReturnDTO save(UsuarioDTO usuarioDTO, Long tipoConta) {
        Usuario usuario = Usuario.builder().document(usuarioDTO.getDocument())
                .name(usuarioDTO.getName()).number(usuarioDTO.getNumber()).build();
        Usuario usuario1 = usuarioRepository.save(usuario);
        var conta = gerarContaUtil.gerarFirstConta(usuario1, tipoConta);
        var contaCreated  =contaRepository.save(conta);
        var adress = saveEnderecoUtil.saveEndereco(usuario1, usuarioDTO);
        var adressCreated = enderecoRepository.save(adress);
        return ReturnDTO.builder().type_account(contaCreated.getType_account().getType_account()).number_account(contaCreated.getNumber_account())
                .verify_digit(contaCreated.getVerify_digit()).balance(contaCreated.getBalance())
                .agency(contaCreated.getAgency()).endereco(adressCreated).name(usuarioDTO.getName()).build();
    }
   @Override
   public Usuario findById(String id){
       return usuarioRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario Não Encontrado"));
   }

}
