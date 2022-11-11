package br.com.bra.cofreinteligente.controller;

import br.com.bra.cofreinteligente.Utils.CSVService;
import br.com.bra.cofreinteligente.dto.SaldoContaDto;
import br.com.bra.cofreinteligente.service.SaldoContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/SaldoConta")
public class SaldoContaController {

    @Autowired
    public SaldoContaService saldoContaService;

    @Autowired
    public CSVService csvService;

    @GetMapping
    public List<SaldoContaDto> getAllSaldoConta (){
       return saldoContaService.getAllSaldoConta();
    }

    @GetMapping("/{idConta}")
    public List<SaldoContaDto> getAllSaldoContabyIdConta(@PathVariable(value = "idConta")Long idConta) throws Exception {
        return saldoContaService.getAllSaldoContaByIdConta(idConta);
    }

    @GetMapping("/Relatorio/{id}")
    public void getSaldoContaByClienteCsv(HttpServletResponse servletResponse, @PathVariable(value = "id")Long id) throws Exception {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition","attachment; filename=\"saldoConta.csv\"");
        csvService.writeSaldoContaByCliente(servletResponse.getWriter(), id);
    }

}
