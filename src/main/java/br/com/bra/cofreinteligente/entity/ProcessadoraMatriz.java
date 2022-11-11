package br.com.bra.cofreinteligente.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProcessadoraMatriz {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToMany(mappedBy = "processadoraMatriz")
    private Set<ProcessadoraFilial> processadoraFilial;
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
    @Size(min = 14, max = 14)
    private String cnpj;
    @NotNull
    private String nome;

}
