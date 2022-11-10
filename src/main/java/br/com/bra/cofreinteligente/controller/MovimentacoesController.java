package br.com.bra.cofreinteligente.controller;

import br.com.bra.cofreinteligente.dto.MovimentacoesDto;
import br.com.bra.cofreinteligente.dto.MovimentacoesDto;
import br.com.bra.cofreinteligente.dto.MovimentacoesDto;
import br.com.bra.cofreinteligente.service.MovimentacoesService;
import br.com.bra.cofreinteligente.service.MovimentacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/Movimentacoes")
public class MovimentacoesController {

    @Autowired
    private MovimentacoesService movimentacoesService;

    @PostMapping
    public MovimentacoesDto addMovimentacoesServiceest(@RequestBody MovimentacoesDto movimentacoesDto){
        return movimentacoesService.addMovimentacoes(movimentacoesDto);
    }

    @GetMapping
    public List<MovimentacoesDto> getMovimentacoes(){
        return movimentacoesService.getAllMovimentacoes();
    }


    @GetMapping("/{id}")
    public MovimentacoesDto getMovimentacoesById(@PathVariable(value = "id") Long id) throws Exception {
        return movimentacoesService.getMovimentacoes(id);
    }

    @GetMapping("/periodocofre/{inicio}/{fim}/{numeroCofre}")
    public List<MovimentacoesDto> getMovimentacoesByPeriodAndNumeroCofre(@PathVariable(value = "inicio") LocalDateTime inicio,
                                                                         @PathVariable(value = "fim") LocalDateTime fim,
                                                                         @PathVariable(value = "numeroCofre") Long numeroCofre){
        return movimentacoesService.getByPeriodAndCofre(inicio, fim, numeroCofre);
    }

    @GetMapping("/periodo/{inicio}/{fim}")
    public List<MovimentacoesDto> getMovimentacoesByPeriodAndNumeroCofre(@PathVariable(value = "inicio") LocalDateTime inicio,
                                                                         @PathVariable(value = "fim") LocalDateTime fim) {
        return movimentacoesService.getAllByPeriod(inicio, fim);
    }
}