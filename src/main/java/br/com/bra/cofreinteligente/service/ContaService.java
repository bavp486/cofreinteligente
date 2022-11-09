package br.com.bra.cofreinteligente.service;

import br.com.bra.cofreinteligente.entity.Conta;
import br.com.bra.cofreinteligente.entity.SaldoConta;
import br.com.bra.cofreinteligente.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    @Autowired
    public ContaRepository contaRepository;

    @Autowired
    public SaldoContaService saldoContaService;

    public Conta addConta(int ag, Long cc){
        var contaTemp = Conta.builder()
                .agencia(ag)
                .conta(cc)
                .build();
        var conta = contaRepository.saveAndFlush(contaTemp);
        saldoContaService.addAbreSaldoConta(conta.getId());
        return conta;
    }

    public List<Conta> getAllConta (){
        return contaRepository.findAll();
    }

}
