package br.com.bra.cofreinteligente.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ProcessadoraFilial {

    @Id
    private Long id;
    @ManyToOne
    private ProcessadoraMatriz processadoraMatriz;

    @OneToOne
    private Endereco endereco;

    @OneToMany(mappedBy = "id_processadora")
    private Set<Contratos> contratos;

    private String cnpj;
    private Long id_Matriz;
    private Long id_endereco;
    private String nome;
}
