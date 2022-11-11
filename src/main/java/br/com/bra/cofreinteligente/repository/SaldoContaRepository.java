package br.com.bra.cofreinteligente.repository;

import br.com.bra.cofreinteligente.entity.Conta;
import br.com.bra.cofreinteligente.entity.SaldoConta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaldoContaRepository extends JpaRepository<SaldoConta, Long> {

    List<SaldoConta> findByConta (Conta conta);

}