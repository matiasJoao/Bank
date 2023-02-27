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
@Entity(name = "Transocoes_contas")
@Table(name = "Transocoes_contas")
public class Transacoes {

    @Id
    @GenericGenerator(name="UUIDGenerator", strategy ="uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    private String id;

    @Column
    private String tipoTransacao;
    @Column
    private String idUsuario;
    @Column
    private String idContaOrigem;
    @Column
    private Integer agencyContaOrigem;
    @Column
    private Integer numberAccountContaOrigem;
    @Column
    private String idContaDestino;
    @Column
    private Integer agencyContaDestino;
    @Column
    private Integer numberAccountContaDestino;
    @Column
    private String tipoTransferencia;
    @Column
    private Double valorTransferencia;
    @Column
    private Integer agency;
    @Column
    private Integer numberAccount;
    @Column
    private Double saldoAntigo;
    @Column
    private Double saldoNovo;
    @Column
    private Double valorDeposito;
    @Column
    private Double saque;
    @Column(nullable = false)
    private Date date;

}
