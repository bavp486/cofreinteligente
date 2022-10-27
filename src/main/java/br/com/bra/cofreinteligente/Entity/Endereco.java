package br.com.bra.cofreinteligente.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Endereco {
    @Id
    private Long id;
    private String rua;
    private String numero;
    private String cidade;
    private String uf;
}
