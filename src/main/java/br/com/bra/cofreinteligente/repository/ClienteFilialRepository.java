package br.com.bra.cofreinteligente.repository;

import br.com.bra.cofreinteligente.entity.ClienteFilial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClienteFilialRepository extends JpaRepository<ClienteFilial, Long> {


//    @Query(value = "select * from alunos as a where a.nome = :nome",
//            nativeQuery = true)
//    List<Aluno> findByNome(@Param("nome") String nome);

    List<ClienteFilial> findAllByNumcontrato(@Param("num")Long num_contrato);
}