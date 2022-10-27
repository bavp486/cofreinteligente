package br.com.bra.cofreinteligente.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cofre {
    @Id
    private long numero_Cofre;
    private String tipo_Cofre;
}
