package br.com.bra.cofreinteligente.controller;

import br.com.bra.cofreinteligente.dto.SaldoCofreDto;
import br.com.bra.cofreinteligente.entity.SaldoCofre;
import br.com.bra.cofreinteligente.service.SaldoCofreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/SaldoCofre")
public class SaldoCofreController {

    @Autowired
    public SaldoCofreService saldoCofreService;

    @GetMapping
    public List<SaldoCofreDto> getAllSaldoCofre(){
        return saldoCofreService.getAllSaldoCofre();
    }

    @GetMapping("/{numCofre}")
    private List<SaldoCofreDto> getAllSaldoCofreByNumCofre(@PathVariable(value = "numCofre") Long numCofre){
        return saldoCofreService.getAllSaldoCofreByNumCofre(numCofre);
    }
}
