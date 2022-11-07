package br.com.bra.cofreinteligente.controller;

import br.com.bra.cofreinteligente.entity.ClienteFilial;
import br.com.bra.cofreinteligente.service.ClienteFilialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Cliente")
public class ClienteController {

    @Autowired
    private ClienteFilialService clienteFilialService;

    @PostMapping
    public ClienteFilial addCliente (@RequestBody ClienteFilial clienteFilial){
        return clienteFilialService.addClienteFilial(clienteFilial);
    }

    @GetMapping
    public List<ClienteFilial> getCliente(){
        return clienteFilialService.getAllClienteFilial();
    }

}
