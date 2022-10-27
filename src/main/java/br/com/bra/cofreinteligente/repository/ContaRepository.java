package br.com.bra.cofreinteligente.repository;

import br.com.bra.cofreinteligente.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
}