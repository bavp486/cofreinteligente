package br.com.bra.cofreinteligente.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProcessadoraMatriz {
    @Id
    private Long id;
    private Long id_Endereco;
    private String cnpj;
    private String nome;
}
