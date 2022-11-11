package br.com.bra.cofreinteligente.dto;

import br.com.bra.cofreinteligente.entity.ProcessadoraMatriz;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class ProcessadoraMatrizDto implements Serializable {
    private Long id;
    @NotNull
    private EnderecoDto endereco;
    private Long id_endereco;
    @Size(min = 14, max = 14)
    private String cnpj;
    @NotNull
    private String nome;

    public ProcessadoraMatrizDto(ProcessadoraMatriz processadoraMatriz) {
        this.id = processadoraMatriz.getId ();
        this.id_endereco = processadoraMatriz.getEndereco().getId();
        this.cnpj = processadoraMatriz.getCnpj ();
        this.nome = processadoraMatriz.getNome ();
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
