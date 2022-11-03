package br.com.bra.cofreinteligente.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ClienteFilial {
    @Id
    private Long id;
    @OneToMany(mappedBy = "id_ClienteFilial")
    private Set<Cofre> cofre;
    @ManyToOne
    @JoinColumn(name = "cliente_matriz_id")
    private ClienteMatriz clienteMatriz;

    private Long id_Matriz;

    @OneToOne(fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.PERSIST)
    private Endereco endereco;

  // @OneToOne (cascade = CascadeType.ALL)
   // private Conta conta;

    @ManyToOne
    @JoinColumn(name = "numero_contrato")
    private Contratos contratos;

//    @ManyToOne
//    @JoinColumn(name = "numero_cofre")
//    private Cofre cofre;


    private Long id_endereco;
    private Long id_cofre;
    private Long id_conta;
    private Long num_contrato;
    private String cnpj;
    private String nome;

}
