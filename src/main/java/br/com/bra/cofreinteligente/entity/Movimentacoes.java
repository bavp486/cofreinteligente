package br.com.bra.cofreinteligente.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Movimentacoes {
    @Id
    private Long id;
    private Long numero_Cofre;
    private LocalDateTime data;
    private BigDecimal valor_Recolhido;
}
