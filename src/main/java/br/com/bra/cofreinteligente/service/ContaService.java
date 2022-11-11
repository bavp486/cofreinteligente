package br.com.bra.cofreinteligente.service;

import br.com.bra.cofreinteligente.entity.Conta;
import br.com.bra.cofreinteligente.entity.ContaDto;
import br.com.bra.cofreinteligente.entity.SaldoConta;
import br.com.bra.cofreinteligente.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    @Autowired
    public ContaRepository contaRepository;

    public List<ContaDto> getAllConta (){
        return contaRepository.findAll().stream()
                .map(ContaDto::new)
                .toList();
    }

}
