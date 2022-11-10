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

    @OneToMany(mappedBy = "clienteFilial")
    private Set<Cofre> cofre;
    @ManyToOne
    @JoinColumn(name = "idMatriz")
    private ClienteMatriz clienteMatriz;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

  @OneToOne(cascade =  CascadeType.ALL)
  @JoinColumn(name = "idConta")
   private Conta conta;

//    private Long id_conta;
    private String cnpj;
    private String nome;

}
