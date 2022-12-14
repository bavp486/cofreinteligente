package br.com.bra.cofreinteligente.repository;

import br.com.bra.cofreinteligente.entity.ClienteFilial;
import br.com.bra.cofreinteligente.entity.Cofre;
import br.com.bra.cofreinteligente.entity.Contratos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClienteFilialRepository extends JpaRepository<ClienteFilial, Long> {


//    @Query(value = "select * from CLIENTE_FILIAL as a where a.NUMCONTRATO = :num",
//            nativeQuery = true)
//    List<ClienteFilial> findAllByNumcontrato(@Param("num")Long num_contrato);

    Optional<ClienteFilial> findByCofre (Cofre cofre);
}