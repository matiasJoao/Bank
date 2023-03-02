package com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.use_cases.dto;

import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Deposito;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Saque;
import com.br.banco_contas_usuarios.com.br.banco_contas_usuarios.domain.Transferencias;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExtratoDTO {
     public List<Saque> saques;
     public List<Deposito> depositos;
     public List<Transferencias> transferenciasEnviadas;
     public List<Transferencias> transferenciasRecebidas;
}
