package br.com.bra.cofreinteligente.dto;

import br.com.bra.cofreinteligente.entity.ClienteMatriz;
import br.com.bra.cofreinteligente.entity.Cofre;
import br.com.bra.cofreinteligente.entity.Movimentacoes;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
public class MovimentacoesDto {
    private Long id;
    private Cofre cofre;
    private Long numero_cofre;
    private LocalDateTime data;
    private BigDecimal valor_Recolhido;


    public MovimentacoesDto(Movimentacoes movimentacoes) {
        this.id = movimentacoes.getId();
        this.cofre = movimentacoes.getCofre();
        this.numero_cofre = movimentacoes.getNumero_cofre();
        this.data = movimentacoes.getData();
        this.valor_Recolhido = movimentacoes.getValor_Recolhido();

    }
}
