package br.com.bra.cofreinteligente.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ClienteMatriz {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(mappedBy = "clienteMatriz")
    private Set<ClienteFilial>  clienteFilial;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
    private String cnpj;
    private String nome;
}
