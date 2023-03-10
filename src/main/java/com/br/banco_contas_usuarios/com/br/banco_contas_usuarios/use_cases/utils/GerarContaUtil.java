package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.utils;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Conta;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.TipoConta;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Usuario;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.exception.exception_class.CriarNovaContaError;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.exception.exception_class.TipoErradoParaCnpjError;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.CreateAccountDTO;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.UsuarioDTO;
import org.springframework.stereotype.Component;

@Component
public class GerarContaUtil {
    private final PegarUsuarioPorIdUtil pegarUsuarioPorIdUtil;
    private final ValidaCnpjUtil validaCnpjUtil;
    Integer agency = 1234;
    int min = 1000;
    int max = 5000;
    int number_random_account = (int) Math.floor(Math.random() * (max - min + 1) + min);

    public GerarContaUtil(PegarUsuarioPorIdUtil pegarUsuarioPorIdUtil, ValidaCnpjUtil validaCnpjUtil) {
        this.pegarUsuarioPorIdUtil = pegarUsuarioPorIdUtil;
        this.validaCnpjUtil = validaCnpjUtil;
    }

    public Conta gerarFirstConta(Usuario usuario, UsuarioDTO usuarioDTO) {

        Conta conta = new Conta();
        conta.setVerify_digit(9);
        conta.setDocument(usuario.getDocument());
        conta.setBalance(0.0);
        conta.setAgency(agency);
        conta.setNumber_account(number_random_account);
        conta.setType_account(usuarioDTO.getTipoConta());
        conta.setId_document(usuario.getId());
        conta.setQuantidadeSaque(usuarioDTO.getTipoConta().getQuantidadeSaque());
        return conta;
    }

    public Conta gerarNewConta(CreateAccountDTO createAccountDTO) {
        var res = pegarUsuarioPorIdUtil.idUser(createAccountDTO.getIdUsuario());
        var cnpj = validaCnpjUtil.valida(createAccountDTO.getDocumentAccount());
        if (!res.isEmpty()) {
            if (createAccountDTO.getTipoConta().getSigla().equalsIgnoreCase("pf") && cnpj) {
                throw new TipoErradoParaCnpjError();
            }
            var conta = Conta.builder().agency(agency).balance(0.0)
                    .document(createAccountDTO.getDocumentAccount())
                    .id_document(res.get().getId())
                    .number_account(number_random_account)
                    .verify_digit(9)
                    .type_account(createAccountDTO.getTipoConta())
                    .quantidadeSaque(createAccountDTO.getTipoConta().getQuantidadeSaque())
                    .build();
            return conta;
        }
        throw new CriarNovaContaError();
    }
}
