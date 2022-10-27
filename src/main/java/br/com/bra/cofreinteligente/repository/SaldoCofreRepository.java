package br.com.bra.cofreinteligente.repository;

import br.com.bra.cofreinteligente.entity.SaldoCofre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaldoCofreRepository extends JpaRepository<SaldoCofre, Long> {
}