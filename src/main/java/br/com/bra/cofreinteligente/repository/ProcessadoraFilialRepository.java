package br.com.bra.cofreinteligente.repository;

import br.com.bra.cofreinteligente.entity.ClienteFilial;
import br.com.bra.cofreinteligente.entity.Movimentacoes;
import br.com.bra.cofreinteligente.entity.ProcessadoraFilial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProcessadoraFilialRepository extends JpaRepository<ProcessadoraFilial, Long> {


    List<ProcessadoraFilial> findByCnpj(Long cnpj);

}