package br.com.bra.cofreinteligente.dto;

import br.com.bra.cofreinteligente.entity.ClienteMatriz;
import br.com.bra.cofreinteligente.entity.Cofre;
import br.com.bra.cofreinteligente.entity.Movimentacoes;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;


@Data
@NoArgsConstructor
public class MovimentacoesDto {
    private Long id;
    private Long numeroCofre;

    private LocalDate data;
    private BigDecimal valorRecolhido;


    public MovimentacoesDto(Movimentacoes movimentacoes) {
        this.id = movimentacoes.getId();
        this.numeroCofre = movimentacoes.getCofre().getNumeroCofre();
        this.data = movimentacoes.getData();
        this.valorRecolhido = movimentacoes.getValorRecolhido();

    }

}