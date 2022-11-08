package br.com.bra.cofreinteligente.dto;

import br.com.bra.cofreinteligente.entity.ClienteMatriz;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
public class ClienteMatrizDto implements Serializable {
    private Long id;
    private Long id_endereco;
    private String cnpj;
    private String nome;

    public ClienteMatrizDto(ClienteMatriz clienteMatriz) {
        this.id = clienteMatriz.getId();
        this.id_endereco = clienteMatriz.getId_endereco();
        this.cnpj = clienteMatriz.getCnpj();
        this.nome = clienteMatriz.getNome();
    }
}