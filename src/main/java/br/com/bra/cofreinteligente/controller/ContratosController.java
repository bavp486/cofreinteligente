package br.com.bra.cofreinteligente.controller;

import br.com.bra.cofreinteligente.dto.ClienteFilialDto;
import br.com.bra.cofreinteligente.dto.ContratosDto;
import br.com.bra.cofreinteligente.entity.Contratos;
import br.com.bra.cofreinteligente.service.ContratosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Contratos")
public class ContratosController {

    @Autowired
    public ContratosService contratosService;

    @PostMapping
    public ContratosDto addContratos (@RequestBody ContratosDto dto) throws Exception {
        return contratosService.addContratos(dto);
    }

    @GetMapping
    public List<ContratosDto> getContratos(){
        return contratosService.getAllContratos();
    }

    @GetMapping("/{id}")
    public ContratosDto getContratosById(@PathVariable(value = "id") Long id) throws Exception {
        return contratosService.getContratosByiD(id);
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteContratosById(@PathVariable(value = "id") Long id) throws Exception {
//        contratosService.deleteContratos(id);
//        return ResponseEntity.noContent().build();
//    }

    @PatchMapping("/{id}/{valor}")
    public ContratosDto alteraContratosValorById (@PathVariable(value = "id")Long id, @PathVariable(value = "valor")Long valor) throws Exception {
        return contratosService.alteraValorContratoById(id,valor);
    }

}
