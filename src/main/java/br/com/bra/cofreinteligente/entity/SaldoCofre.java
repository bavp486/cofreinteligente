package br.com.bra.cofreinteligente.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class SaldoCofre {
    @Id
    private Long id;

    @OneToMany(mappedBy = "id")
    private Set<Movimentacoes> movimentacoes;

    private Long id_Movimentacao;
    @JsonFormat(pattern = "dd-MM-yyyy@HH:mm:ss.SSSZ")
    private LocalDateTime data;
    private BigDecimal saldo;
}
