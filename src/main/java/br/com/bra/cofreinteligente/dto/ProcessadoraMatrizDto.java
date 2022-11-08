package br.com.bra.cofreinteligente.dto;

import br.com.bra.cofreinteligente.entity.ProcessadoraMatriz;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ProcessadoraMatrizDto implements Serializable {
    private Long id;
    private Long id_endereco;
    private String cnpj;
    private String nome;

    public ProcessadoraMatrizDto(ProcessadoraMatriz processadoraMatriz) {
        this.id = processadoraMatriz.getId ();
        this.id_endereco = processadoraMatriz.getId_endereco ();
        this.cnpj = processadoraMatriz.getCnpj ();
        this.nome = processadoraMatriz.getNome ();
    }
}
