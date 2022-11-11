package br.com.bra.cofreinteligente.repository;

import br.com.bra.cofreinteligente.entity.Cofre;
import br.com.bra.cofreinteligente.entity.SaldoCofre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface SaldoCofreRepository extends JpaRepository<SaldoCofre, Long> {

    List<SaldoCofre> findByCofre (Cofre cofre);

    Optional<SaldoCofre> findByCofreAndData (Cofre cofre, LocalDate data);
}