package br.com.bra.cofreinteligente.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProcessadoraFilial {

    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "processadoraMatriz_id")
    private ProcessadoraMatriz processadoraMatriz;
    private String cnpj;
    private Long id_Matriz;
    private Long id_Endereco;
    private String nome;
}
