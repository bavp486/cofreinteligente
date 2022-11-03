package br.com.bra.cofreinteligente.entity;

import javax.persistence.*;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "id_endereco")
    private ClienteMatriz clienteMatriz;

    @OneToOne(fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.PERSIST, mappedBy = "id_endereco")
    private ClienteFilial clienteFilial;

    @OneToOne(mappedBy = "id_endereco")
    private ProcessadoraMatriz processadoraMatriz;

    @OneToOne(mappedBy = "id_endereco")
    private ProcessadoraFilial processadoraFilial;

    private String rua;
    private String numero;
    private String cidade;
    private String uf;
}
