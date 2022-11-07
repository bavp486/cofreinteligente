package br.com.bra.cofreinteligente.dto;

import lombok.Data;

import java.io.Serializable;


@Data
public class ClienteFilialDto implements Serializable {
    private final Long id;
    private final Long id_Matriz;
    private final Long id_Endereco;
    private final Long id_Cofre;
    private final Long id_Conta;
    private final Long numero_Contrato;
    private final String cnpj;
    private final String nome;
}