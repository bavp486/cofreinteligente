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
    private Long numero_cofre;

    @OneToMany(mappedBy = "numero_cofre")
    private Set<Movimentacoes> movimentacoes;

    @OneToMany(mappedBy = "numero_cofre")
    private Set<SaldoCofre> saldoCofres;

    @ManyToOne
    private ClienteFilial clienteFilial;

    private Long id_ClienteFilial;
    private String tipo_cofre;
}
