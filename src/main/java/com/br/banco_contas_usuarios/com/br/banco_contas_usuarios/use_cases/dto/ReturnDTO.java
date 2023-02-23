package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Endereco;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReturnDTO {

    private String name;
    private Endereco endereco;
    private Integer agency;
    private Integer number_account;
    private Integer verify_digit;
    private Double balance;
    private String type_account;
}
