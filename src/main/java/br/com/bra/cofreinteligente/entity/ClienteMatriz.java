package br.com.bra.cofreinteligente.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Set;


@Entity
public class ClienteMatriz {

    @Id
    private Long id;
    @OneToMany(mappedBy = "clienteFilial_id")
    private Set<ClienteFilial>  clienteFilial;

    @OneToOne(mappedBy = "id")
    private Endereco endereco;


    private Long id_endereco;
    private String cnpj;
    private String nome;
}
