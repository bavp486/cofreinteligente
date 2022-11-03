package br.com.bra.cofreinteligente.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Cofre {

    @Id
    private Long numero_cofre;

    @OneToMany(mappedBy = "numero_cofre")
    private Set<Movimentacoes> movimentacoes;

    @OneToMany(mappedBy = "numero_cofre")
    private Set<SaldoCofre> saldoCofres;

//    @OneToMany(mappedBy = "id_cofre")
//    private Set<ClienteFilial> clienteFiliais;

    @ManyToOne
    //@JoinColumn(name = "cliente_filial_id")
    private ClienteFilial clienteFilial;
    private Long id_ClienteFilial;

    private String tipo_cofre;
}
