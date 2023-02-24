package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.utils;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.exception.exception_class.NameExceptioError;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Component
public class NameValidationUtil {

    public Boolean nomeValidation(String name){
        Pattern pattern = Pattern.compile("^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$");
        Matcher matcher = pattern.matcher(name);
        Boolean verify;
        if(matcher.matches()){
            verify = true;
        }
        else{
            verify = false;
        }
        return verify;
    }
    public Boolean resValidation(String name){
        if(nomeValidation(name)){
            return true;
        }
        throw new NameExceptioError();
    }
}
