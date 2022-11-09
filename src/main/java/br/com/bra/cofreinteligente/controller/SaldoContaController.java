package br.com.bra.cofreinteligente.controller;

import br.com.bra.cofreinteligente.dto.SaldoContaDto;
import br.com.bra.cofreinteligente.service.SaldoContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/SaldoConta")
public class SaldoContaController {

    @Autowired
    public SaldoContaService saldoContaService;

    @GetMapping
    public List<SaldoContaDto> getAllSaldoConta (){
       return saldoContaService.getAllSaldoConta();
    }

    @GetMapping("/{idConta}")
    public List<SaldoContaDto> getAllSaldoContabyIdConta(@PathVariable(value = "idConta")Long idConta){
        return saldoContaService.getAllSaldoContaByIdConta(idConta);
    }

}
