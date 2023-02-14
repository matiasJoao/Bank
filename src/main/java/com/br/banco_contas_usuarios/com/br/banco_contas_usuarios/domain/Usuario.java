package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain;

import lombok.*;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;

    @OneToMany
    @JoinColumn(name = "Conta", nullable = false)
    private List<Conta> contas;

    @Column(name = "name", nullable = false)
    @NotBlank
    private String name;

    @Column(name = "cpf", nullable = false)
    @NotBlank
    @CPF
    private String cpf;

    @OneToMany
    @JoinColumn(name = "Endereco", nullable = false)
    @NotBlank
    private List<Endereco> enderecos;

    @Column(name = "number", nullable = false)
    @NotBlank
    private String number;

}
