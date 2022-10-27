package br.com.bra.cofreinteligente.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cofre {
    @Id
    private Long numero_Cofre;
    private String tipo_Cofre;
}
