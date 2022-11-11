package br.com.bra.cofreinteligente.dto;

import br.com.bra.cofreinteligente.entity.SaldoConta;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaldoContaDto implements Serializable {
    private Long id;
    private Long idConta;
    private LocalDate data;
    private BigDecimal saldo;

    public SaldoContaDto(SaldoConta saldoConta) {
        this.id = saldoConta.getId();
        this.idConta = saldoConta.getConta().getId();
        this.data = saldoConta.getData();
        this.saldo = saldoConta.getSaldo();
    }
}