package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
@Entity
@Table
public class Transferencias {

    @Id
    @GenericGenerator(name="UUIDGenerator", strategy ="uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    private String id;
    @Column(nullable = false)
    private String idUsuario;
    @Column(nullable = false)
    private String idContaOrigem;
    @Column(nullable = false)
    private Integer agenciaContaOrigem;
    @Column(nullable = false)
    private Integer numeroContaOrigem;
    @Column(nullable = false)
    private String idContaDestino;
    @Column(nullable = false)
    private Integer agenciaContaDestino;
    @Column(nullable = false)
    private Integer numeroContaDestino;
    @Column(nullable = false)
    private String tipoTransferencia;
    @Column(nullable = false)
    private Double valorTransferencia;
    @Column(nullable = false)
    private Double saldoAntigo;
    @Column(nullable = false)
    private Double saldoNovo;
    @Column(nullable = false)
    private Date date;

}
