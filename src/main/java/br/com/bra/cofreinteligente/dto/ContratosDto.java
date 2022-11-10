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
    private Long idProcessadora;
    private Long idCliente;
    private Long numeroContrato;
    private BigDecimal valor;

    public ContratosDto(Contratos contratos) {
        this.idProcessadora = contratos.getProcessadoraFilial().getId();
        this.idCliente = contratos.getClienteFilial().getId();
        this.numeroContrato = contratos.getNumeroContrato();
        this.valor = contratos.getValor();
    }
}