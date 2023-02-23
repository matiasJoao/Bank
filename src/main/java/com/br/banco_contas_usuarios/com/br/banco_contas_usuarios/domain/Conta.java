package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain;

import lombok.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
@Entity(name = "Conta")
@Table(name = "Conta")
public class Conta {

    @Id
    @GenericGenerator(name="UUIDGenerator", strategy ="uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    private String id;
    @Column(name = "id_document", nullable = false)
    @NotBlank
    private String id_document;
    @Column(name = "document", nullable = false)
    @NotBlank
    private String document;
    @Column(name = "agency", nullable = false)
    private Integer agency;
    @Column(name = "number_account", nullable = false)
    private Integer number_account;

    @ManyToOne
    @JoinColumn(name = "type_account", nullable = false)
    private TipoConta type_account;

    @Column(name = "verify_digit", nullable = false)
    private Integer verify_digit;

    @Column(name = "balance",  nullable = false)
    private Double balance;

}
