package br.com.bra.cofreinteligente.repository;

import br.com.bra.cofreinteligente.entity.ClienteFilial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClienteFilialRepository extends JpaRepository<ClienteFilial, Long> {


//    @Query(value = "select * from ClienteFilial as a where a.numContrato = :num",
//            nativeQuery = true)
    List<ClienteFilial> findAllByNumcontrato(@Param("num")Long num_contrato);
}