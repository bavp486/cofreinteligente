package br.com.bra.cofreinteligente.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ClienteMatriz {
    @Id
    private Long id;
    private Long id_Endereco;
    private String cnpj;
    private String nome;
}
