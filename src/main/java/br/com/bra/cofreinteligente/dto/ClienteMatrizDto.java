package br.com.bra.cofreinteligente.dto;

import br.com.bra.cofreinteligente.entity.ClienteMatriz;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Data
@NoArgsConstructor
public class ClienteMatrizDto implements Serializable {
    private Long id;
    @NotNull
    private EnderecoDto endereco;
    private Long id_endereco;
    @Size(min = 14, max = 14)
    private String cnpj;
    @NotNull
    private String nome;

    public ClienteMatrizDto(ClienteMatriz clienteMatriz) {
        this.id = clienteMatriz.getId();
        this.id_endereco = clienteMatriz.getEndereco().getId();
        this.cnpj = clienteMatriz.getCnpj();
        this.nome = clienteMatriz.getNome();
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