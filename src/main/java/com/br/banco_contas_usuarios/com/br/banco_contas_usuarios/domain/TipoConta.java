package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
@Entity(name = "Tipo_Conta")
@Table(name = "Tipo_Conta")
public class TipoConta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "type_account", nullable = false)
    private String type_account;
}
