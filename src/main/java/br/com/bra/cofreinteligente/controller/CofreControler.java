package br.com.bra.cofreinteligente.controller;

import br.com.bra.cofreinteligente.dto.CofreDto;
import br.com.bra.cofreinteligente.dto.ContratosDto;
import br.com.bra.cofreinteligente.service.CofreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Cofre")
public class CofreControler {

    @Autowired
    public CofreService cofreService;

    @PostMapping
    public CofreDto addCofre (@RequestBody CofreDto dto) throws Exception {
        return cofreService.addCofre(dto);
    }

    @GetMapping
    public List<CofreDto> getAllCofre(){
        return cofreService.getAllCofre();
    }

    @GetMapping("/{numCofre}")
    public CofreDto getCofreByNumCofre (@PathVariable(value = "numCofre")Long numCofre) throws Exception {
        return cofreService.getCofreByNumCofre(numCofre);
    }

    @GetMapping("/Cliente/{id}")
    public List<CofreDto> getAllCofreByIdCliente (@PathVariable(value = "id")Long id) throws Exception {
        return cofreService.getAllCofreByIdCliente(id);
    }

    @DeleteMapping("/{numCofre}")
    public ResponseEntity<Void> deleteCofreByNumCofre (@PathVariable(value = "numCofre")Long numCofre) throws Exception {
        cofreService.deleteCofreByNumCofre(numCofre);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{numCofre}/{tCofre}")
    public CofreDto alteraTipoCofreByNumCofre(@PathVariable(value = "numCofre")Long numCofre,@PathVariable(value = "tCofre") String tCofre) throws Exception {
        return cofreService.alteraTipoCofreByNumCofre(numCofre,tCofre) ;
    }



}
