package br.com.bra.cofreinteligente.dto;

import br.com.bra.cofreinteligente.entity.Cofre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CofreDto implements Serializable {
    private Long numeroCofre;
    private Long idClienteFilial;
    private String tipoCofre;

    public CofreDto(Cofre cofre) {
        this.numeroCofre = cofre.getNumeroCofre();
        this.idClienteFilial = cofre.getIdClienteFilial();
        this.tipoCofre = cofre.getTipoCofre();
    }
}