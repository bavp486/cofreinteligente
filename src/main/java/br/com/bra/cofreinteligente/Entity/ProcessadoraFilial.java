package br.com.bra.cofreinteligente.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProcessadoraFilial {
    @Id
    private Long id;
    private String cnpj;
    private Long id_Matriz;
    private Long id_Endereco;
    private String nome;
}
