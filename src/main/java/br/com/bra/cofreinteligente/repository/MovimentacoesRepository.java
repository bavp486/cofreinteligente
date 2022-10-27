package br.com.bra.cofreinteligente.repository;

import br.com.bra.cofreinteligente.entity.Movimentacoes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacoesRepository extends JpaRepository<Movimentacoes, Long> {
}