package br.com.bra.cofreinteligente.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
public class Contratos {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    private ProcessadoraFilial processadoraFilial;

    @OneToMany(mappedBy = "num_contrato")
    private Set<ClienteFilial> clienteFilials;

    private Long id_processadora;
    private Long numero_contrato;
    private BigDecimal valor;
}
