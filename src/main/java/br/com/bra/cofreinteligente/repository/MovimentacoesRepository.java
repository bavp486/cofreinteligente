package br.com.bra.cofreinteligente.repository;

import br.com.bra.cofreinteligente.entity.Movimentacoes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MovimentacoesRepository extends JpaRepository<Movimentacoes, Long> {

    List<Movimentacoes> findByDataBetween(LocalDateTime inicio, LocalDateTime fim);
}