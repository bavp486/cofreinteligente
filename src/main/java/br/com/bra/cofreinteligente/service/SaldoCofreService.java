package br.com.bra.cofreinteligente.service;

import br.com.bra.cofreinteligente.dto.SaldoCofreDto;
import br.com.bra.cofreinteligente.entity.Cofre;
import br.com.bra.cofreinteligente.entity.Movimentacoes;
import br.com.bra.cofreinteligente.entity.SaldoCofre;
import br.com.bra.cofreinteligente.repository.CofreRepository;
import br.com.bra.cofreinteligente.repository.SaldoCofreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SaldoCofreService {

    @Autowired
    public SaldoCofreRepository saldoCofreRepository;

    @Autowired
    public CofreRepository cofreRepository;

    public void addAbreSaldoCofre (Long numCofre){
        var nCofre = new Cofre();
        nCofre.setNumeroCofre(numCofre);
        var cofre = SaldoCofre.builder()
                .cofre(nCofre)
                .saldo(BigDecimal.ZERO)
                .data(LocalDate.now())
                .build();
        saldoCofreRepository.save(cofre);
    }

    public List<SaldoCofreDto> getAllSaldoCofre(){
        return saldoCofreRepository.findAll().stream()
                .map(SaldoCofreDto::new)
                .toList();
    }

    public List<SaldoCofreDto> getAllSaldoCofreByNumCofre (Long numCofre) throws Exception {
        var cofre = cofreRepository.findById(numCofre);
        if(cofre.isEmpty()){
            throw new Exception("Cofre não localizado");
        }
        return saldoCofreRepository.findByCofre(cofre.get()).stream()
                .map(SaldoCofreDto::new)
                .toList();
    }

    public void addSaldoNaConta(Movimentacoes movimentacoes){

    }
}
