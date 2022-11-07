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
    private ClienteMatriz clienteMatriz;

    private Long id_Matriz;

    @OneToOne
    private Endereco endereco;

  @OneToOne
   private Conta conta;

    @ManyToOne
    private Contratos contratos;

    private Long id_endereco;
    private Long id_cofre;
    private Long id_conta;
    private Long num_contrato;
    private String cnpj;
    private String nome;

}
