package br.com.bra.cofreinteligente.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ProcessadoraFilial {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private ProcessadoraMatriz processadoraMatriz;

    @OneToOne
    private Endereco endereco;

    @OneToMany(mappedBy = "id_processadora")
    private Set<Contratos> contratos;

    private Long cnpj;
    private Long id_Matriz;
    private Long id_endereco;
    private String nome;
}
