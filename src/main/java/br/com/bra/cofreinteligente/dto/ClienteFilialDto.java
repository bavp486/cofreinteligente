package br.com.bra.cofreinteligente.dto;

import br.com.bra.cofreinteligente.entity.ClienteFilial;
import br.com.bra.cofreinteligente.entity.Conta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Data
@NoArgsConstructor
public class ClienteFilialDto implements Serializable {
    private Long id;
    @NotNull
    private EnderecoDto endereco;
    private Conta conta;
    private Long idMatriz;
    private  Long id_endereco;
    private Long id_conta;
    private Long numcontrato;
    @Size(min = 14, max = 14)
    private  String cnpj;
    @NotNull
    private String nome;

    public ClienteFilialDto(ClienteFilial clienteFilial) {
        this.id = clienteFilial.getId();
        this.idMatriz = clienteFilial.getClienteMatriz().getId();
        this.id_endereco = clienteFilial.getEndereco().getId();
        this.id_conta = clienteFilial.getConta().getId();
        this.cnpj = clienteFilial.getCnpj();
        this.nome = clienteFilial.getNome();
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

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ContaDto implements Serializable{
        private Long id;
        private int agencia;
        private Long conta;
    }
}