package br.com.bra.cofreinteligente.dto;

import br.com.bra.cofreinteligente.entity.ProcessadoraFilial;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ProcessadoraFilialDto implements Serializable {
    private Long id;
    private String cnpj;
    private Long id_Matriz;
    private Long id_endereco;
    private String nome;

    public ProcessadoraFilialDto(ProcessadoraFilial processadoraFilial) {
        this.id = processadoraFilial.getId ();
        this.cnpj = processadoraFilial.getCnpj ();
        this.id_Matriz = processadoraFilial.getId_Matriz ();
        this.id_endereco = processadoraFilial.getId_endereco ();
        this.nome = processadoraFilial.getNome ();
    }
}
