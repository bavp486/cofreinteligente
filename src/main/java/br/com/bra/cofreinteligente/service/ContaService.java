package br.com.bra.cofreinteligente.service;

import br.com.bra.cofreinteligente.entity.Conta;
import br.com.bra.cofreinteligente.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    @Autowired
    public ContaRepository contaRepository;

    public Conta addConta(int ag, Long cc){
        var conta = Conta.builder()
                .agencia(ag)
                .conta(cc)
                .build();
        return contaRepository.saveAndFlush(conta);
    }

    public List<Conta> getAllConta (){
        return contaRepository.findAll();
    }

}
