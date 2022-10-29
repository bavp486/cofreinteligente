package br.com.bra.cofreinteligente.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Cofre {

    @Id
    private Long numero_Cofre;
    @OneToMany(mappedBy = "movimentacoes_id")
    private Set<Movimentacoes> movimentacoes;
    private String tipo_Cofre;
}
