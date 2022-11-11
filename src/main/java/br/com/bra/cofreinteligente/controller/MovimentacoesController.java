package br.com.bra.cofreinteligente.controller;

import br.com.bra.cofreinteligente.dto.MovimentacoesDto;
import br.com.bra.cofreinteligente.service.MovimentacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Movimentacoes")
public class MovimentacoesController {

    @Autowired
    private MovimentacoesService movimentacoesService;

    @PostMapping
    public MovimentacoesDto addMovimentacoesServices(@RequestBody MovimentacoesDto movimentacoesDto) throws Exception {
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

    @GetMapping("/periodocofre/{numeroCofre}")
    public List<MovimentacoesDto> getMovimentacoesByPeriodAndNumeroCofre(@PathVariable(value = "numeroCofre") Long numeroCofre, @RequestParam String inicio, String fim) throws Exception {
        return movimentacoesService.getByPeriodAndCofre(inicio, fim, numeroCofre);
    }

    @GetMapping("/periodo")
    public List<MovimentacoesDto> getMovimentacoesByPeriod(@RequestParam String inicio, String fim) {
        return movimentacoesService.getAllByPeriod(inicio, fim);
    }
}