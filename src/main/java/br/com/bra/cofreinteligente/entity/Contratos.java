package br.com.bra.cofreinteligente.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
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
