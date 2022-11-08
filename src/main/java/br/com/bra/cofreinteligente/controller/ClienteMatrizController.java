package br.com.bra.cofreinteligente.controller;

import br.com.bra.cofreinteligente.dto.ClienteFilialDto;
import br.com.bra.cofreinteligente.dto.ClienteMatrizDto;
import br.com.bra.cofreinteligente.entity.ClienteFilial;
import br.com.bra.cofreinteligente.service.ClienteMatrizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ClienteMatriz")
public class ClienteMatrizController {

    @Autowired
    public ClienteMatrizService clienteMatrizService;

    @PostMapping
    public ClienteMatrizDto addClienteMatriz(@RequestBody ClienteMatrizDto clienteMatrizDto){
        return clienteMatrizService.addClienteMatriz(clienteMatrizDto);
    }

    @GetMapping
    public List<ClienteMatrizDto> getClienteMatriz(){
        return clienteMatrizService.getAllClienteMatriz();
    }

    @GetMapping("/{id}")
    public ClienteMatrizDto getClienteMatrizById(@PathVariable(value = "id") Long id) throws Exception {
        return clienteMatrizService.getClienteMatriz(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClienteMatrizById(@PathVariable(value = "id") Long id) throws Exception {
        clienteMatrizService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ClienteMatrizDto alteraClienteMatrizNameById (@PathVariable(value = "id") Long id, @RequestBody ClienteMatrizDto clienteMatrizDto) throws Exception {
        return clienteMatrizService.alteraNomeClientePorId(id, clienteMatrizDto);
    }

}
