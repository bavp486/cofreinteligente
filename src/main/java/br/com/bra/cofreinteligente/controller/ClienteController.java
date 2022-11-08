package br.com.bra.cofreinteligente.controller;

import br.com.bra.cofreinteligente.dto.ClienteFilialDto;
import br.com.bra.cofreinteligente.entity.ClienteFilial;
import br.com.bra.cofreinteligente.service.ClienteFilialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Cliente")
public class ClienteController {

    @Autowired
    private ClienteFilialService clienteFilialService;

    @PostMapping
    public ClienteFilialDto addCliente (@RequestBody ClienteFilialDto clienteFilialDto){
        return clienteFilialService.addClienteFilial(clienteFilialDto);
    }

    @GetMapping
    public List<ClienteFilial> getCliente(){
        return clienteFilialService.getAllClienteFilial();
    }

    @GetMapping("/{id}")
    public ClienteFilialDto getClienteById(@PathVariable(value = "id") Long id) throws Exception {
        return clienteFilialService.getClienteFilial(id);
    }

    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<Void> deleteClienteById(@PathVariable(value = "id") Long id) throws Exception {
        clienteFilialService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ClienteFilial alteraClienteNameById (@PathVariable(value = "id")Long id, @RequestBody ClienteFilialDto clienteFilialDto) throws Exception {
        return clienteFilialService.alteraNomeClientePorId(id,clienteFilialDto);
    }

}
