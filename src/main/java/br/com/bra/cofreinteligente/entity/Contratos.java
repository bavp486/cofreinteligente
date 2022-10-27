package br.com.bra.cofreinteligente.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Contratos {
    @Id
    private Long id;
    private Long id_Processadora;
    private Long numero_Contrato;
    private BigDecimal valor;
}
