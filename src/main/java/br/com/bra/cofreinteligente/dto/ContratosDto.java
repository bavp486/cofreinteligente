package br.com.bra.cofreinteligente.dto;

import br.com.bra.cofreinteligente.entity.Contratos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
@NoArgsConstructor
public class ContratosDto implements Serializable {
    private Long id_processadora;
    private Long numero_contrato;
    private BigDecimal valor;

    public ContratosDto(Contratos contratos) {
        this.id_processadora = contratos.getId_processadora();
        this.numero_contrato = contratos.getNumero_contrato();
        this.valor = contratos.getValor();
    }
}