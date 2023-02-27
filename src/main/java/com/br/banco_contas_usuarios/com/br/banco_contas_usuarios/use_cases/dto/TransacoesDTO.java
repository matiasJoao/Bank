package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto;

import lombok.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransacoesDTO {
    public String idContaOrigem;

    public String idContaDestino;

    public String tipoTransferencia;

    public Double valorTransferencia;

    public Date date;

}
