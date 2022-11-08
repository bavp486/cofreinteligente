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
    private Long numero_contrato;
    @ManyToOne
    private ProcessadoraFilial processadoraFilial;

    @OneToMany(mappedBy = "numcontrato")
    private Set<ClienteFilial> clienteFilials;

    private Long id_processadora;

    private BigDecimal valor;
}
