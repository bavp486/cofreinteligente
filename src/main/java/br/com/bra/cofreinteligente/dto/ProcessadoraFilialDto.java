package br.com.bra.cofreinteligente.dto;

import br.com.bra.cofreinteligente.entity.ProcessadoraFilial;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class ProcessadoraFilialDto implements Serializable {
    private Long id;
    @NotNull
    private EnderecoDto endereco;
    @Size(min = 14, max = 14)
    private String cnpj;
    private Long id_Matriz;
    private Long id_endereco;
    @NotNull
    private String nome;

    public ProcessadoraFilialDto(ProcessadoraFilial processadoraFilial) {
        this.id = processadoraFilial.getId ();
        this.cnpj = processadoraFilial.getCnpj ();
        this.id_Matriz = processadoraFilial.getProcessadoraMatriz ().getId();
        this.id_endereco = processadoraFilial.getEndereco().getId();
        this.nome = processadoraFilial.getNome ();
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class EnderecoDto implements Serializable {
        private Long id;
        private String rua;
        private String numero;
        private String cidade;
        private String uf;
    }
}
