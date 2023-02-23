package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {


    private String street_name;

    private Integer adress_number;

    private String complement;

    private Integer cep;
}
