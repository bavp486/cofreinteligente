package br.com.bra.cofreinteligente.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ProcessadoraMatriz {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(mappedBy = "id")
    private Set<ProcessadoraFilial> processadoraFiliais;

    @OneToOne
    private Endereco endereco;

    private Long id_endereco;
    private String cnpj;
    private String nome;
}
