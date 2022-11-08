package br.com.bra.cofreinteligente.controller;

import br.com.bra.cofreinteligente.dto.ClienteFilialDto;
import br.com.bra.cofreinteligente.dto.ProcessadoraFilialDto;
import br.com.bra.cofreinteligente.dto.ProcessadoraMatrizDto;
import br.com.bra.cofreinteligente.service.ClienteFilialService;
import br.com.bra.cofreinteligente.service.ProcessadoraFilialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ProcessadoraFilial")
public class ProcessadoraFilialController {

    @Autowired
    private ProcessadoraFilialService processadoraFilialService;

    @PostMapping
    public ProcessadoraFilialDto addProcessadoraFilial (@RequestBody ProcessadoraFilialDto processadoraFilialDto){
        return processadoraFilialService.addProcessadoraFilial ( processadoraFilialDto );
    }

    @GetMapping
    public List<ProcessadoraFilialDto> getProcessadoraFilial(){
        return processadoraFilialService.getAllProcessadoraFilial ();
    }

    @GetMapping("/{id}")
    public ProcessadoraFilialDto getProcessadoraFilialById(@PathVariable(value = "id") Long id) throws Exception {
        return processadoraFilialService.getProcessadoraFilial ( id );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProcessadoraFilialById(@PathVariable(value = "id") Long id) throws Exception {
        processadoraFilialService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ProcessadoraFilialDto alteraProcessadoraFilialNameById (@PathVariable(value = "id")Long id, @RequestBody ProcessadoraFilialDto processadoraFilialDto) throws Exception {
        return processadoraFilialService.alteraNomeProcessadoraFilialPorId ( id, processadoraFilialDto);
    }

}
