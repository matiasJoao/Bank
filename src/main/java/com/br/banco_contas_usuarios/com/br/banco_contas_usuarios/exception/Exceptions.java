package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.exception;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.exception.exception_class.CpfExceptionError;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.exception.exception_class.CriarNovaContaError;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.exception.exception_class.TipoErradoParaCnpjError;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.CriarNovaContaErrorDTO;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.MensageErrorExceptionDTO;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto.TipoErradoParaCnpjErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class Exceptions extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CpfExceptionError.class)
    public ResponseEntity CpfExceptionError(CpfExceptionError e) {
        var date = new Date();
        MensageErrorExceptionDTO mensageErrorExceptionDTO = new MensageErrorExceptionDTO("Error", HttpStatus.BAD_REQUEST, date);
        return ResponseEntity.status(mensageErrorExceptionDTO.httpStatus).body(mensageErrorExceptionDTO);
    }

    @ExceptionHandler(TipoErradoParaCnpjError.class)
    public ResponseEntity TipoErradoParaCnpjError(TipoErradoParaCnpjError e) {
        var date = new Date();
        TipoErradoParaCnpjErrorDTO tipoErradoParaCnpjError = new TipoErradoParaCnpjErrorDTO("Error ao tentar criar conta tipo pessoa juridica para um CNPJ", HttpStatus.BAD_REQUEST, date);
        return ResponseEntity.status(tipoErradoParaCnpjError.httpStatus).body(tipoErradoParaCnpjError);
    }

    @ExceptionHandler(CriarNovaContaError.class)
    public ResponseEntity CriarNovaContaError(CriarNovaContaError e) {
        var date = new Date();
        CriarNovaContaErrorDTO criarNovaContaErrorDTO = new CriarNovaContaErrorDTO("Error ao criar nova conta", HttpStatus.INTERNAL_SERVER_ERROR, date);
        return ResponseEntity.status(criarNovaContaErrorDTO.httpStatus).body(criarNovaContaErrorDTO);
    }
}
