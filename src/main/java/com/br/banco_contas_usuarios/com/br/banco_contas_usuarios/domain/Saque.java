package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
@Entity
@Table
public class Saque {

    @Id
    @GenericGenerator(name="UUIDGenerator", strategy ="uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    private String id;
    @Column(nullable = false)
    private String idUsuario;
    @Column(nullable = false)
    private String documentConta;
    @Column(nullable = false)
    private String idConta;
    @Column(nullable = false)
    private Integer agencia;
    @Column(nullable = false)
    private Integer numeroConta;
    @Column(nullable = false)
    private Double saldoAntigo;
    @Column(nullable = false)
    private Double saldoNovo;
    @Column(nullable = false)
    private Double valorSaque;

}
