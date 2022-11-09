package br.com.bra.cofreinteligente.dto;

import br.com.bra.cofreinteligente.entity.SaldoCofre;
import br.com.bra.cofreinteligente.entity.SaldoConta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaldoCofreDto implements Serializable {
    private Long id;
    private Long numeroCofre;
    private LocalDateTime data;
    private BigDecimal saldo;

    public SaldoCofreDto(SaldoCofre saldoCofre) {
        this.id = saldoCofre.getId();
        this.numeroCofre = saldoCofre.getNumeroCofre();
        this.data = saldoCofre.getData();
        this.saldo = saldoCofre.getSaldo();
    }
}