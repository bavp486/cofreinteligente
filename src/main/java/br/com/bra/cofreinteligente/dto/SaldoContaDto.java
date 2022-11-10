package br.com.bra.cofreinteligente.dto;

import br.com.bra.cofreinteligente.entity.SaldoConta;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaldoContaDto implements Serializable {
    private Long id;
    private Long idConta;
    private LocalDateTime data;
    private BigDecimal saldo;

    public SaldoContaDto(SaldoConta saldoConta) {
        this.id = saldoConta.getIdConta();
        this.idConta = saldoConta.getIdConta();
        this.data = saldoConta.getData();
        this.saldo = saldoConta.getSaldo();
    }
}