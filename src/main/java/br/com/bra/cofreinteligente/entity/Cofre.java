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
public class Cofre {

    @Id
    private Long numeroCofre;

    @OneToMany(mappedBy = "numeroCofre")
    private Set<Movimentacoes> movimentacoes;

    @OneToMany(mappedBy = "numeroCofre")
    private Set<SaldoCofre> saldoCofres;

    @ManyToOne
    private ClienteFilial clienteFilial;

    private Long idClienteFilial;
    private String tipoCofre;
}
