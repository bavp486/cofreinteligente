package br.com.bra.cofreinteligente.entity;

import javax.persistence.*;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private ClienteMatriz clienteMatriz;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private ClienteFilial clienteFilial;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private ProcessadoraMatriz processadoraMatriz;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private ProcessadoraFilial processadoraFilial;

    private String rua;
    private String numero;
    private String cidade;
    private String uf;
}
