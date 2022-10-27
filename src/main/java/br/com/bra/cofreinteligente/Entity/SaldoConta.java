package br.com.bra.cofreinteligente.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class SaldoConta {
    @Id
    private Long id;
    private Long id_Conta;
    private LocalDateTime data;
    private BigDecimal saldo;
}
