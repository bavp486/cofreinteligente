package br.com.bra.cofreinteligente.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class ProcessadoraMatriz {
    @Id
    private Long id;
    @OneToMany(mappedBy = "processadoraFilial_id")
    private Set<ProcessadoraFilial> processadoraFilials;
    private Long id_Endereco;
    private String cnpj;
    private String nome;
}
