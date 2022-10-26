package br.com.bra.cofreinteligente.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Conta {
    @Id
    private Long id;
    private int agencia;
    private Long conta;
}
