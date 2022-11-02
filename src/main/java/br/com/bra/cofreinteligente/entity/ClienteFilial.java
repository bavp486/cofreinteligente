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
    @OneToOne(mappedBy = "id")
    private Endereco endereco;

    @OneToOne(mappedBy = "id")
    private Conta conta;

    @ManyToOne
    @JoinColumn(name = "numero_contrato")
    private Contratos contratos;

    @ManyToOne
    @JoinColumn(name = "numero_cofre")
    private Cofre cofre;


    private Long id_endereco;
    private Long id_cofre;
    private Long id_conta;
    private Long num_contrato;
    private String cnpj;
    private String nome;

    public ClienteMatriz getClienteMatriz() {
        return clienteMatriz;
    }

    public void setClienteMatriz(ClienteMatriz clienteMatriz) {
        this.clienteMatriz = clienteMatriz;
    }
}
