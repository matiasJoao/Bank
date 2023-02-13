package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain;

import lombok.*;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
@Entity(name = "Conta")
@Table(name = "Conta")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;

    @Column(name = "agency", nullable = false)
    @NotBlank
    private Integer agency;
    @Column(name = "number_account", nullable = false)
    @NotBlank
    private Integer number_account;

    @ManyToOne
    @JoinColumn(name = "type_account", nullable = false)
    @NotBlank
    private TipoConta type_account;

    @Column(name = "verify_digit", nullable = false)
    @NotBlank
    @CPF
    private Integer verify_digit;

}
