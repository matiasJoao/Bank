package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransferenciaDTO {

    public Integer agencyContaOrigem;
    public Integer numberAccountContaOrigem;
    public Integer agencyContaDestino;
    public Integer numberAccountContaDestino;
    public String tipoTransferencia;
    public Double valorTransferencia;
    public Date date;
}
