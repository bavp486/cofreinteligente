package br.com.bra.cofreinteligente.service;

import br.com.bra.cofreinteligente.dto.SaldoCofreDto;
import br.com.bra.cofreinteligente.entity.SaldoCofre;
import br.com.bra.cofreinteligente.repository.SaldoCofreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SaldoCofreService {

    @Autowired
    public SaldoCofreRepository saldoCofreRepository;

    public void addAbreSaldoCofre (Long numCofre){
        var cofre = SaldoCofre.builder()
                .numeroCofre(numCofre)
                .saldo(BigDecimal.ZERO)
                .build();
        saldoCofreRepository.save(cofre);
    }

    public List<SaldoCofreDto> getAllSaldoCofre(){
        return saldoCofreRepository.findAll().stream()
                .map(SaldoCofreDto::new)
                .toList();
    }

    public List<SaldoCofreDto> getAllSaldoCofreByNumCofre (Long numCofre){
        return saldoCofreRepository.findByNumeroCofre(numCofre).stream()
                .map(SaldoCofreDto::new)
                .toList();
    }
}
