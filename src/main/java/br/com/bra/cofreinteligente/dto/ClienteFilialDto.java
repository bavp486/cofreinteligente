package br.com.bra.cofreinteligente.dto;

import br.com.bra.cofreinteligente.entity.ClienteFilial;
import br.com.bra.cofreinteligente.entity.Conta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
public class ClienteFilialDto implements Serializable {
    private Long id;

    private EnderecoDto endereco;
    private Conta conta;
    private Long id_Matriz;
    private  Long id_endereco;
    private Long id_conta;
    private Long num_contrato;
    private  String cnpj;
    private String nome;

    public ClienteFilialDto(ClienteFilial clienteFilial) {
        this.id = clienteFilial.getId();
        this.id_Matriz = clienteFilial.getId_Matriz();
        this.id_endereco = clienteFilial.getId_endereco();
        this.id_conta = clienteFilial.getId_conta();
        this.num_contrato = clienteFilial.getNum_contrato();
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