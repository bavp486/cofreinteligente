package br.com.bra.cofreinteligente.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContaDto implements Serializable {
    public Long id;
    public int agencia;
    public Long conta;

    public ContaDto(Conta conta) {
        this.id = conta.getId();
        this.agencia = conta.getAgencia();
        this.conta = conta.getConta();
    }
}