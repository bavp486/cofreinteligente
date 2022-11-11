package br.com.bra.cofreinteligente.controller;

import br.com.bra.cofreinteligente.dto.ClienteFilialDto;
import br.com.bra.cofreinteligente.entity.ClienteFilial;
import br.com.bra.cofreinteligente.service.ClienteFilialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ClienteFilial")
public class ClienteFilialController {

    @Autowired
    private ClienteFilialService clienteFilialService;


    @PostMapping
    public ResponseEntity<Object> addCliente (@RequestBody ClienteFilialDto clienteFilialDto){
        return ResponseEntity.status(HttpStatus.CREATED).body("Cliente " +
                clienteFilialService.addClienteFilial(clienteFilialDto).getNome()
                + " cadastrado com sucesso");
    }

    @GetMapping
    public ResponseEntity<Object> getCliente(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(clienteFilialService.getAllClienteFilial());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object>  getClienteById(@PathVariable(value = "id") Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(clienteFilialService.getClienteFilial(id));
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteClienteById(@PathVariable(value = "id") Long id) throws Exception {
//        clienteFilialService.delete(id);
//        return ResponseEntity.noContent().build();
//    }

    @PatchMapping("/{id}")
    public ClienteFilialDto alteraClienteNameById (@PathVariable(value = "id")Long id, @RequestBody ClienteFilialDto clienteFilialDto) throws Exception {
        return clienteFilialService.alteraNomeClientePorId(id,clienteFilialDto);
    }

}
