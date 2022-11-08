package br.com.bra.cofreinteligente.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id_endereco")
    private ClienteMatriz clienteMatriz;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id_endereco")
    private ClienteFilial clienteFilial;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id_endereco")
    private ProcessadoraMatriz processadoraMatriz;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id_endereco")
    private ProcessadoraFilial processadoraFilial;

    private String rua;
    private String numero;
    private String cidade;
    private String uf;
}
