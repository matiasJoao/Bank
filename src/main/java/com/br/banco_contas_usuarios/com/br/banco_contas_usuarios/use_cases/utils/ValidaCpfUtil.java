package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.utils;

import br.com.caelum.stella.validation.CPFValidator;
import org.springframework.stereotype.Component;

@Component
public class ValidaCpfUtil {
    public boolean valida(String cpf) {
        CPFValidator cpfValidator = new CPFValidator();
        try {
            cpfValidator.assertValid(cpf);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

}
