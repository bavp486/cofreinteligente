package br.com.bra.cofreinteligente.repository;

import br.com.bra.cofreinteligente.entity.SaldoConta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaldoContaRepository extends JpaRepository<SaldoConta, Long> {
}