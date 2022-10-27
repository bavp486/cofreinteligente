package br.com.bra.cofreinteligente.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ClienteFinal {
    @Id
    private Long id;
    private Long id_Matriz;
    private Long id_Endereco;
    private Long id_Cofre;
    private Long id_Conta;
    private Long numeroContrato;
    private String cnpj;
    private String nome;
}
