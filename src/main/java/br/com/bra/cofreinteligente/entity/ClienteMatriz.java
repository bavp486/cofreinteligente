package br.com.bra.cofreinteligente.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;


@Entity
public class ClienteMatriz {

    @Id
    private Long id;
    @OneToMany(mappedBy = "clienteFilial_id")
    private Set<ClienteFilial>  clienteFilial;
    private Long id_Endereco;
    private String cnpj;
    private String nome;
}
