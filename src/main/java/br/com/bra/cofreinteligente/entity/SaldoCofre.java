package br.com.bra.cofreinteligente.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class SaldoCofre {
    @Id
    private Long id;
    private Long id_Movimentacao;
    private LocalDateTime data;
    private BigDecimal saldo;
}
