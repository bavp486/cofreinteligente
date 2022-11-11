package br.com.bra.cofreinteligente.service;

import br.com.bra.cofreinteligente.dto.SaldoCofreDto;
import br.com.bra.cofreinteligente.dto.SaldoContaDto;
import br.com.bra.cofreinteligente.entity.ClienteMatriz;
import br.com.bra.cofreinteligente.entity.Conta;
import br.com.bra.cofreinteligente.entity.Movimentacoes;
import br.com.bra.cofreinteligente.entity.SaldoConta;
import br.com.bra.cofreinteligente.repository.ClienteFilialRepository;
import br.com.bra.cofreinteligente.repository.ContaRepository;
import br.com.bra.cofreinteligente.repository.SaldoContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SaldoContaService {

    @Autowired
    public SaldoContaRepository saldoContaRepository;

    @Autowired
    public ContaRepository contaRepository;

    @Autowired
    public ClienteFilialRepository clienteFilialRepository;


    public void addAbreSaldoConta(Long id){
        var conta = new Conta();
        conta.setId(id);
        var sConta = SaldoConta.builder()
                .conta(conta)
                .saldo(BigDecimal.ZERO)
                .data(LocalDate.now())
                .build();
        saldoContaRepository.save(sConta);
    }

    public List<SaldoContaDto> getAllSaldoConta(){
        return saldoContaRepository.findAll().stream()
                .map(SaldoContaDto::new)
                .toList();
    }

    public List<SaldoContaDto> getAllSaldoContaByIdConta (Long idConta) throws Exception {
        var conta = contaRepository.findById(idConta);
        if(conta.isEmpty()){
            throw new Exception("Conta não localizada");
        }
        return saldoContaRepository.findByConta(conta.get()).stream()
                .map(SaldoContaDto::new)
                .toList();
    }

    public void addSaldoConta (Movimentacoes movimentacoes) throws Exception {
        var cliente = clienteFilialRepository.findByCofre(movimentacoes.getCofre());
        if(cliente.isEmpty()){
            throw new Exception("Cliente não localizado");
        }
        var conta = cliente.get().getConta();
        var sConta = saldoContaRepository.findByContaAndData(conta,movimentacoes.getData());
        if(sConta.isEmpty()){
            var  saldoConta = SaldoConta.builder()
                    .conta(conta)
                    .data(movimentacoes.getData())
                    .saldo(BigDecimal.ZERO.add(movimentacoes.getValorRecolhido()))
                    .build();
            saldoContaRepository.save(saldoConta);
        } else {
            var saldoConta = SaldoConta.builder()
                    .id(sConta.get().getId())
                    .conta(sConta.get().getConta())
                    .data(sConta.get().getData())
                    .saldo(sConta.get().getSaldo().add(movimentacoes.getValorRecolhido()))
                    .build();
            saldoContaRepository.save(saldoConta);
        }
    }

}
