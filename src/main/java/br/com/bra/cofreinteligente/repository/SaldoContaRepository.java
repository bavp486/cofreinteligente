package br.com.bra.cofreinteligente.repository;

import br.com.bra.cofreinteligente.entity.Cofre;
import br.com.bra.cofreinteligente.entity.Conta;
import br.com.bra.cofreinteligente.entity.SaldoCofre;
import br.com.bra.cofreinteligente.entity.SaldoConta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface SaldoContaRepository extends JpaRepository<SaldoConta, Long> {

    List<SaldoConta> findByConta (Conta conta);

    Optional<SaldoConta> findByContaAndData (Conta conta, LocalDate data);

}