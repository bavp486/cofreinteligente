package br.com.bra.cofreinteligente.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

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

    @OneToMany(mappedBy = "cofre")
    private Set<Movimentacoes> movimentacoes;

    @OneToMany(mappedBy = "cofre")
    private Set<SaldoCofre> saldoCofres;

    @ManyToOne
    private ClienteFilial clienteFilial;

//    private Long idClienteFilial;
    @Nullable
    private String tipoCofre;
}
