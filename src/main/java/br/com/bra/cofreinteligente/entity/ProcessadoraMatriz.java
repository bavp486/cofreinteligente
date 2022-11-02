package br.com.bra.cofreinteligente.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Set;

@Entity
public class ProcessadoraMatriz {
    @Id
    private Long id;
    @OneToMany(mappedBy = "processadoraFilial_id")
    private Set<ProcessadoraFilial> processadoraFilials;

    @OneToOne(mappedBy = "id")
    private Endereco endereco;

    private Long id_endereco;
    private String cnpj;
    private String nome;
}
