package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MensageErrorExceptionDTO {

    public String mensagem;
    public HttpStatus httpStatus;
    public Date date;
}
