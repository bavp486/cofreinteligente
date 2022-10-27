package br.com.bra.cofreinteligente.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cofre {
    @Id
    private long numero_Cofre;
    private String tipo_Cofre;
}
