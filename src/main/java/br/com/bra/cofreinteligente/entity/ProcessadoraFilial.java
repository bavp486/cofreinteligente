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
    @JoinColumn(name = "idMatriz")
    private ProcessadoraMatriz processadoraMatriz;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @OneToMany(mappedBy = "processadoraFilial")
    private Set<Contratos> contratos;

    private Long cnpj;

    private String nome;

}
