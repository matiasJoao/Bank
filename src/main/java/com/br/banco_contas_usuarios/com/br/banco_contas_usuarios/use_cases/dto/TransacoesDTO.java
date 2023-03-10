package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto;

import lombok.*;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransacoesDTO {
    public String documentOrigem;
    public String documentDestino;
    public String idContaOrigem;
    public Integer agencyContaOrigem;
    public Integer numberAccountContaOrigem;
    public String idContaDestino;
    public Integer agencyContaDestino;
    public Integer numberAccountContaDestino;
    public String tipoTransferencia;
    public Double valorTransferencia;
    public Double valorDeposito;
    public Double valorSaque;
    public Integer agency;
    public Integer numberAccount;
    public Date date;

}
