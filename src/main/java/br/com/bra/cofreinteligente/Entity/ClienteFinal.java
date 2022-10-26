package br.com.bra.cofreinteligente.Entity;

import javax.persistence.Entity;

@Entity
public class ClienteFinal {

    Long id_Matriz;
    Long id_Endereco;
    Long id_Cofre;
    Long id_Conta;
    Long numeroContrato;
    String cnpj;
    String nome;
}
