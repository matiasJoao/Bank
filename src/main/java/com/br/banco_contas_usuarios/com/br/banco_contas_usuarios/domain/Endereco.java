package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain;


import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
@Entity(name = "Endereco")
@Table(name = "Endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;

    @Column(name = "street_name", nullable = false)
    @NotBlank
    private String street_name;

    @Column(name = "adress_number", nullable = false)
    private Integer adress_number;

    @Column(name = "complement", nullable = false)
    @NotBlank
    private String complement;

    @Column(name = "cep", nullable = false)
    private Integer cep;


}
