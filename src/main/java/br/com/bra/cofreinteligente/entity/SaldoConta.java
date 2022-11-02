package br.com.bra.cofreinteligente.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class SaldoConta {
    @Id
    private Long id;

    @ManyToOne
    private Conta conta;

    private Long id_conta;
    @JsonFormat(pattern = "dd-MM-yyyy@HH:mm:ss.SSSZ")
    private LocalDateTime data;
    private BigDecimal saldo;
}
