package br.com.bra.cofreinteligente.service;

import br.com.bra.cofreinteligente.dto.SaldoCofreDto;
import br.com.bra.cofreinteligente.dto.SaldoContaDto;
import br.com.bra.cofreinteligente.entity.SaldoConta;
import br.com.bra.cofreinteligente.repository.SaldoContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SaldoContaService {

    @Autowired
    public SaldoContaRepository saldoContaRepository;

    public void addAbreSaldoConta(Long id){
        var conta = SaldoConta.builder()
                .idConta(id)
                .saldo(BigDecimal.ZERO)
                .data(LocalDateTime.now())
                .build();
        saldoContaRepository.save(conta);
    }

    public List<SaldoContaDto> getAllSaldoConta(){
        return saldoContaRepository.findAll().stream()
                .map(SaldoContaDto::new)
                .toList();
    }

    public List<SaldoContaDto> getAllSaldoContaByIdConta (Long idConta){
        return saldoContaRepository.findByIdConta(idConta).stream()
                .map(SaldoContaDto::new)
                .toList();
    }

}
