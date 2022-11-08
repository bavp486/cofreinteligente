package br.com.bra.cofreinteligente.controller;

import br.com.bra.cofreinteligente.dto.ClienteFilialDto;
import br.com.bra.cofreinteligente.entity.ClienteFilial;
import br.com.bra.cofreinteligente.service.ClienteFilialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ClienteFilial")
public class ClienteFilialController {

    @Autowired
    private ClienteFilialService clienteFilialService;

    @PostMapping
    public ClienteFilialDto addCliente (@RequestBody ClienteFilialDto clienteFilialDto){
        return clienteFilialService.addClienteFilial(clienteFilialDto);
    }

    @GetMapping
    public List<ClienteFilialDto> getCliente(){
        return clienteFilialService.getAllClienteFilial();
    }

    @GetMapping("/{id}")
    public ClienteFilialDto getClienteById(@PathVariable(value = "id") Long id) throws Exception {
        return clienteFilialService.getClienteFilial(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClienteById(@PathVariable(value = "id") Long id) throws Exception {
        clienteFilialService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ClienteFilialDto alteraClienteNameById (@PathVariable(value = "id")Long id, @RequestBody ClienteFilialDto clienteFilialDto) throws Exception {
        return clienteFilialService.alteraNomeClientePorId(id,clienteFilialDto);
    }

}
