package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.utils;

import br.com.caelum.stella.validation.CNPJValidator;
import org.springframework.stereotype.Component;

@Component
public class ValidaCnpjUtil {

    public boolean valida(String cnpj) {
        CNPJValidator cnpjValidator = new CNPJValidator();
        try {
            cnpjValidator.assertValid(cnpj);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
