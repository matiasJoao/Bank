package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.impl;


import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Usuario;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.exception.exception_class.CpfExceptionError;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.exception.exception_class.TipoErradoParaCnpjError;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.repositorys.EnderecoRepository;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.adapter.ContaAdapter;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.adapter.EnderecoAdapter;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.adapter.UsuarioAdapter;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.MensageErrorExceptionDTO;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.ReturnDTO;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.UsuarioDTO;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.services.UsuarioService;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuarioImpl implements UsuarioService {


    private final UsuarioAdapter usuarioAdapter;
    private final ContaAdapter contaAdapter;
    private final GerarContaUtil gerarContaUtil;
    private final SaveEnderecoUtil saveEnderecoUtil;
    private final ValidaCpfUtil validaCpfUtil;
    private final ValidaCnpjUtil validaCnpjUtil;
    private final EnderecoAdapter enderecoAdapter;
    private final NameValidationUtil nameValidationUtil;



    public UsuarioImpl(UsuarioAdapter usuarioAdapter, ContaAdapter contaAdapter, GerarContaUtil gerarContaUtil, SaveEnderecoUtil saveEnderecoUtil, ValidaCpfUtil validaCpfUtil, ValidaCnpjUtil validaCnpjUtil, EnderecoAdapter enderecoAdapter, NameValidationUtil nameValidationUtil ) {
        this.usuarioAdapter = usuarioAdapter;
        this.contaAdapter = contaAdapter;
        this.gerarContaUtil = gerarContaUtil;
        this.saveEnderecoUtil = saveEnderecoUtil;
        this.validaCpfUtil = validaCpfUtil;
        this.validaCnpjUtil = validaCnpjUtil;
        this.enderecoAdapter = enderecoAdapter;
        this.nameValidationUtil = nameValidationUtil;
    }


    @Override
    public ReturnDTO save(UsuarioDTO usuarioDTO, Long tipoConta) {
       var cpfVal = validaCpfUtil.valida(usuarioDTO.getDocument());
       var cnpjVal = validaCnpjUtil.valida(usuarioDTO.getDocument());
       var nameRes = nameValidationUtil.resValidation(usuarioDTO.getName());
        if(cpfVal){
            Usuario usuario = Usuario.builder().document(usuarioDTO.getDocument())
                    .name(usuarioDTO.getName()).number(usuarioDTO.getNumber()).build();
            Usuario usuario1 = usuarioAdapter.saveUser(usuario);
            var conta = gerarContaUtil.gerarFirstConta(usuario1, tipoConta);
            var contaCreated = contaAdapter.saveConta(conta);
            var adress = saveEnderecoUtil.saveEndereco(usuario1, usuarioDTO);
            var adressCreated = enderecoAdapter.save(adress);
            System.out.println(adressCreated);
            System.out.println(contaCreated);
            return ReturnDTO.builder().type_account(contaCreated.getType_account().getType_account()).number_account(contaCreated.getNumber_account())
                    .verify_digit(contaCreated.getVerify_digit()).balance(contaCreated.getBalance())
                    .agency(contaCreated.getAgency()).endereco(adressCreated).name(usuarioDTO.getName()).build();
        } else if (cnpjVal) {
            if(tipoConta == 1){
                throw new TipoErradoParaCnpjError();
            }
            Usuario usuario = Usuario.builder().document(usuarioDTO.getDocument())
                    .name(usuarioDTO.getName()).number(usuarioDTO.getNumber()).build();
            Usuario usuario1 = usuarioAdapter.saveUser(usuario);
            var conta = gerarContaUtil.gerarFirstConta(usuario1, tipoConta);
            var contaCreated = contaAdapter.saveConta(conta);
            var adress = saveEnderecoUtil.saveEndereco(usuario1, usuarioDTO);
            var adressCreated = enderecoAdapter.save(adress);
            System.out.println(adressCreated);
            System.out.println(contaCreated);
            return ReturnDTO.builder().type_account(contaCreated.getType_account().getType_account()).number_account(contaCreated.getNumber_account())
                    .verify_digit(contaCreated.getVerify_digit()).balance(contaCreated.getBalance())
                    .agency(contaCreated.getAgency()).endereco(adressCreated).name(usuarioDTO.getName()).build();
        }
        throw new CpfExceptionError();
    }

    @Override
    public Usuario findById(String id) {
        return usuarioAdapter.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario Não Encontrado"));
    }

}
