package br.com.bra.cofreinteligente.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class SaldoCofre {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    private Cofre cofre;
    private Long numeroCofre;
    @JsonFormat(pattern = "dd-MM-yyyy@HH:mm:ss.SSSZ")
    private LocalDateTime data;
    private BigDecimal saldo;
}
