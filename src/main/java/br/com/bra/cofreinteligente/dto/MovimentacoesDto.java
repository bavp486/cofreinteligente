package br.com.bra.cofreinteligente.dto;

import br.com.bra.cofreinteligente.entity.ClienteMatriz;
import br.com.bra.cofreinteligente.entity.Cofre;
import br.com.bra.cofreinteligente.entity.Movimentacoes;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;


@Data
@NoArgsConstructor
public class MovimentacoesDto {
    private Long id;
    private Cofre cofre;
    private Long numeroCofre;

    @JsonFormat(pattern = "dd-MM-yyyy@HH:mm:ss.SSSZ")
    private LocalDateTime data;
    private BigDecimal valorRecolhido;


    public MovimentacoesDto(Movimentacoes movimentacoes) {
        this.id = movimentacoes.getId();
        this.cofre = movimentacoes.getCofre();
        this.numeroCofre = movimentacoes.getNumeroCofre();
        this.data = movimentacoes.getData();
        this.valorRecolhido = movimentacoes.getValorRecolhido();

    }

}