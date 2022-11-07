package br.com.bra.cofreinteligente.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id_conta")
    private ClienteFilial clienteFilial;

    @OneToMany(mappedBy = "id_conta")
    private Set<SaldoConta> saldoContas;



    private int agencia;
    private Long conta;


}
