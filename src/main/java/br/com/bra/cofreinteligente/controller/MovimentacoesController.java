package br.com.bra.cofreinteligente.controller;

import br.com.bra.cofreinteligente.dto.MovimentacoesDto;
import br.com.bra.cofreinteligente.dto.MovimentacoesDto;
import br.com.bra.cofreinteligente.dto.MovimentacoesDto;
import br.com.bra.cofreinteligente.service.MovimentacoesService;
import br.com.bra.cofreinteligente.service.MovimentacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Movimentacoes")
public class MovimentacoesController {

    @Autowired
    private MovimentacoesService movimentacoesService;

    @PostMapping
    public MovimentacoesDto addMovimentacoesServiceest (@RequestBody MovimentacoesDto movimentacoesDto){
        return movimentacoesService.addMovimentacoes;
    }

    @GetMapping
    public List<MovimentacoesDto> getMovimentacoes(){
        return movimentacoesService.getAllMovimentacoes();
    }


    @GetMapping("/{id}")
    public MovimentacoesDto getMovimentacoesById(@PathVariable(value = "id") Long id){
        return movimentacoesService.getMovimentacoes(id);
    }
}