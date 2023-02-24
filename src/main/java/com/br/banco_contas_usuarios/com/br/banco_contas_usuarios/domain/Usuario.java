package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.br.CPF;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
@Entity(name = "Usuario")
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GenericGenerator(name="UUIDGenerator", strategy ="uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    private String id;

    @Column(name = "name", nullable = false)
    @NotBlank
    private String name;

    @Column(name = "document", nullable = false, unique = true)
    @NotBlank
    private String document;

    @Column(name = "number", nullable = false)
    @NotBlank
    private String number;

}
