package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Endereco;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private String name;
    private String document;
    private EnderecoDTO endereco;
    private String number;
}
