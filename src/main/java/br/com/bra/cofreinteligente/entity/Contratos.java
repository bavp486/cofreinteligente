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
    private Long numeroContrato;
    @ManyToOne
    private ProcessadoraFilial processadoraFilial;

    @OneToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name = "cliente")
    private ClienteFilial clienteFilial;

    private BigDecimal valor;
}
