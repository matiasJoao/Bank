package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;


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
    @GenericGenerator(name="UUIDGenerator", strategy ="uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    private String id;
    @Column(name = "usuario_id")
    private String idUsuario;
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
