package br.com.bra.cofreinteligente.dto;

import br.com.bra.cofreinteligente.entity.SaldoCofre;
import br.com.bra.cofreinteligente.entity.SaldoConta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaldoCofreDto implements Serializable {
    private Long id;
    @NotNull
    private Long numeroCofre;
    private LocalDate data;
    private BigDecimal saldo;

    public SaldoCofreDto(SaldoCofre saldoCofre) {
        this.id = saldoCofre.getId();
        this.numeroCofre = saldoCofre.getCofre().getNumeroCofre();
        this.data = saldoCofre.getData();
        this.saldo = saldoCofre.getSaldo();
    }
}