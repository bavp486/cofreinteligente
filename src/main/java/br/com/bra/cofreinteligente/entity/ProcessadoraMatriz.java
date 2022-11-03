package br.com.bra.cofreinteligente.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ProcessadoraMatriz {
    @Id
    private Long id;

    @OneToMany(mappedBy = "id")
    private Set<ProcessadoraFilial> processadoraFiliais;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    private Long id_endereco;
    private String cnpj;
    private String nome;
}
