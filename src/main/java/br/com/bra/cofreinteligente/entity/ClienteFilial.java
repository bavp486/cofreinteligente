package br.com.bra.cofreinteligente.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ClienteFilial {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(mappedBy = "id_ClienteFilial")
    private Set<Cofre> cofre;

    @ManyToOne
    private ClienteMatriz clienteMatriz;

    private Long id_Matriz;

    @OneToOne
    private Endereco endereco;

  @OneToOne
   private Conta conta;

    @ManyToOne
    private Contratos contratos;

    private Long id_endereco;
    private Long id_conta;
    private Long numcontrato;
    private String cnpj;
    private String nome;

}
