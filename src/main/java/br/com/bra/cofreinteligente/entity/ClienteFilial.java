package br.com.bra.cofreinteligente.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ClienteFilial {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cliente_matriz_id")
    private ClienteMatriz clienteMatriz;

    private Long id_Matriz;
    private Long id_Endereco;
    private Long id_Cofre;
    private Long id_Conta;
    private Long numero_Contrato;
    private String cnpj;
    private String nome;

    public ClienteMatriz getClienteMatriz() {
        return clienteMatriz;
    }

    public void setClienteMatriz(ClienteMatriz clienteMatriz) {
        this.clienteMatriz = clienteMatriz;
    }
}
