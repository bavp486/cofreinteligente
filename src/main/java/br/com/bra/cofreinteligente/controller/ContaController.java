package br.com.bra.cofreinteligente.controller;

import br.com.bra.cofreinteligente.entity.Conta;
import br.com.bra.cofreinteligente.entity.ContaDto;
import br.com.bra.cofreinteligente.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Conta")
public class ContaController {

    @Autowired
    public ContaService contaService;

    @GetMapping
    public List<ContaDto> getAllConta(){
        return contaService.getAllConta();
    }
}
