package br.com.bra.cofreinteligente.repository;

import br.com.bra.cofreinteligente.entity.Cofre;
import br.com.bra.cofreinteligente.entity.Movimentacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface MovimentacoesRepository extends JpaRepository<Movimentacoes, Long> {

    //    @Query(value = "select * from CLIENTE_FILIAL as a where a.NUMCONTRATO = :num",
//            nativeQuery = true)
//    @Query(value = "SELECT * FROM MOVIMENTACOES as M WHERE M.DATA BETWEEN :ini AND :fim", nativeQuery = true)
    List<Movimentacoes> findByDataBetween(LocalDate inicio, LocalDate fim);

    List<Movimentacoes> findByDataBetweenAndCofre(LocalDate inicio, LocalDate fim, Cofre cofre);
}