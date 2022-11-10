package br.com.bra.cofreinteligente.controller;

import br.com.bra.cofreinteligente.dto.MovimentacoesDto;
import br.com.bra.cofreinteligente.dto.MovimentacoesDto;
import br.com.bra.cofreinteligente.dto.MovimentacoesDto;
import br.com.bra.cofreinteligente.service.MovimentacoesService;
import br.com.bra.cofreinteligente.service.MovimentacoesService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
class RecebeData{
    private LocalDate inicio;
    private LocalDate fim;
}
@RestController
@RequestMapping("/Movimentacoes")
public class MovimentacoesController {

    @Autowired
    private MovimentacoesService movimentacoesService;

    @PostMapping
    public MovimentacoesDto addMovimentacoesServices(@RequestBody MovimentacoesDto movimentacoesDto){
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
    public List<MovimentacoesDto> getMovimentacoesByPeriodAndNumeroCofre(@PathVariable(value = "numeroCofre") Long numeroCofre, @RequestBody RecebeData recebeData) throws Exception {
        var inicio = recebeData.getInicio();
        var fim = recebeData.getFim();
        return movimentacoesService.getByPeriodAndCofre(inicio, fim, numeroCofre);
    }

    @GetMapping("/periodo")
    public List<MovimentacoesDto> getMovimentacoesByPeriod(@RequestBody RecebeData recebeData) {
        var inicio = recebeData.getInicio();
        var fim = recebeData.getFim();
        return movimentacoesService.getAllByPeriod(inicio, fim);
    }
}