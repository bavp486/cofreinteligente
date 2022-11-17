package br.com.bra.cofreinteligente.controller;

import br.com.bra.cofreinteligente.service.CSVService;
import br.com.bra.cofreinteligente.dto.SaldoCofreDto;
import br.com.bra.cofreinteligente.service.SaldoCofreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/SaldoCofre")
public class SaldoCofreController {

    @Autowired
    public SaldoCofreService saldoCofreService;

    @Autowired
    public CSVService csvService;

    @GetMapping
    public List<SaldoCofreDto> getAllSaldoCofre(){
        return saldoCofreService.getAllSaldoCofre();
    }

    @GetMapping("/{numCofre}")
    private List<SaldoCofreDto> getAllSaldoCofreByNumCofre(@PathVariable(value = "numCofre") Long numCofre) throws Exception {
        return saldoCofreService.getAllSaldoCofreByNumCofre(numCofre);
    }

    @GetMapping("/Relatorio/{id}")
    public void getSaldoCofreByClienteCsv(HttpServletResponse servletResponse, @PathVariable(value = "id")Long id) throws Exception {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition","attachment; filename=\"saldoCofre.csv\"");
        csvService.writeSaldoCofreByCliente(servletResponse.getWriter(), id);
    }

}
