package br.com.bra.cofreinteligente.controller;

import br.com.bra.cofreinteligente.dto.ProcessadoraMatrizDto;
import br.com.bra.cofreinteligente.service.ProcessadoraMatrizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ProcessadoraMatriz")
public class ProcessadoraMatrizController {

    @Autowired
    public ProcessadoraMatrizService processadoraMatrizService;

    @PostMapping
    public ProcessadoraMatrizDto addProcessdoraMatriz(@RequestBody ProcessadoraMatrizDto processadoraMatrizDto){
        return processadoraMatrizService.addProcessadoraMatriz ( processadoraMatrizDto );
    }

    @GetMapping
    public List<ProcessadoraMatrizDto> getProcessadoraMatriz(){
        return processadoraMatrizService.getAllProcessadoraMatriz ();
    }

    @GetMapping("/{id}")
    public ProcessadoraMatrizDto getProcessadoraMatrizById(@PathVariable(value = "id") Long id) throws Exception {
        return processadoraMatrizService.getProcessadoraMatriz (id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProcessadoraMatrizById(@PathVariable(value = "id") Long id) throws Exception {
        processadoraMatrizService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ProcessadoraMatrizDto alteraProcessadoraMatrizNameById (@PathVariable(value = "id") Long id, @RequestBody ProcessadoraMatrizDto processadoraMatrizDto) throws Exception {
        return processadoraMatrizService.alteraNomeClientePorId(id, processadoraMatrizDto);
    }

}
