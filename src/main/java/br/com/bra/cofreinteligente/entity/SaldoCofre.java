package br.com.bra.cofreinteligente.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class SaldoCofre {
    @Id
    private Long id;
    private long id_Movimentacao;
    private LocalDateTime data;
    private BigDecimal saldo;
}
