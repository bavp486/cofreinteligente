package br.com.bra.cofreinteligente.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id_conta")
    private ClienteFilial clienteFilial;

    @OneToMany(mappedBy = "idConta")
    private Set<SaldoConta> saldoContas;

    private int agencia;
    private Long conta;


}
