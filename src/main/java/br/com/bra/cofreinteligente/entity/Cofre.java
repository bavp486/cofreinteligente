package br.com.bra.cofreinteligente.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Cofre {

    @Id
    private Long numero_cofre;

    @OneToMany(mappedBy = "numero_cofre")
    private Set<Movimentacoes> movimentacoes;

    @OneToMany(mappedBy = "id_cofre")
    private Set<ClienteFilial> clienteFilials;



    private String tipo_cofre;
}
