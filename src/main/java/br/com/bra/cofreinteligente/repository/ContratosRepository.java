package br.com.bra.cofreinteligente.repository;

import br.com.bra.cofreinteligente.entity.Contratos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratosRepository extends JpaRepository<Contratos, Long> {
}