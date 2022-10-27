package br.com.bra.cofreinteligente.repository;

import br.com.bra.cofreinteligente.entity.Cofre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CofreRepository extends JpaRepository<Cofre, Long> {
}