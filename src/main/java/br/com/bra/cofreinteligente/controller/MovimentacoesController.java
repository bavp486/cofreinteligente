package br.com.bra.cofreinteligente.controller;

import br.com.bra.cofreinteligente.service.CSVService;
import br.com.bra.cofreinteligente.dto.MovimentacoesDto;
import br.com.bra.cofreinteligente.service.MovimentacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/Movimentacoes")
public class MovimentacoesController {

    @Autowired
    public MovimentacoesService movimentacoesService;

    @Autowired
    public CSVService csvService;

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

    @GetMapping("/relatorio")
    public void getMovimentacoesCsv(HttpServletResponse servletResponse) throws Exception {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition","attachment; filename=\"movimentacaoGeral.csv\"");
        csvService.writeMovimentacaoToCsv(servletResponse.getWriter());
    }

    @GetMapping("/Relatorio/{id}")
    public void getMovimentacoesByClienteCsv(HttpServletResponse servletResponse, @PathVariable(value = "id")Long id) throws Exception {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition","attachment; filename=\"movimentacaoCliente.csv\"");
        csvService.writeMovimentacaoByClienteToCsv(servletResponse.getWriter(), id);
    }
}