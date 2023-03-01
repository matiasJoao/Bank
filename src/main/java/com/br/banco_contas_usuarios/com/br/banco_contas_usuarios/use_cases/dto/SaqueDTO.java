package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto;

import lombok.*;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaqueDTO {

    private String document;
    private Integer agencia;
    private Integer numeroConta;
    private Double valorSaque;
    private Double saldoAntigo;
    private Double saldoNovo;

    private Date date;

}
