package br.com.bra.cofreinteligente.repository;

import br.com.bra.cofreinteligente.entity.SaldoCofre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaldoCofreRepository extends JpaRepository<SaldoCofre, Long> {

    List<SaldoCofre> findByNumeroCofre (Long numCofre);
}