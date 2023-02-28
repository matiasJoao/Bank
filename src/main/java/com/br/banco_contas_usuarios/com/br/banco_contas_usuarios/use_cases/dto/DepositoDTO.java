package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepositoDTO {
    public String document;
    public Integer agency;
    public Integer number_account;
    public Double depositoValor;
    public Double saldoAnterior;
    public Double novoSaldo;

    public Date date;

    public String idUsuario;
}
