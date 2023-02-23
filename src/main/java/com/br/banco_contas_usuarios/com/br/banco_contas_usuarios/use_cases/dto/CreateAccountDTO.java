package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto;


import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.TipoConta;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountDTO {

    public String idUsuario;
    public String documentAccount;
    public TipoConta tipoConta;
}
