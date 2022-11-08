package br.com.bra.cofreinteligente.controller;

import br.com.bra.cofreinteligente.entity.Endereco;
import br.com.bra.cofreinteligente.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Endereco")
public class EnderecoController {

    @Autowired
    public EnderecoService enderecoService;

    @GetMapping
    public List<Endereco> getEndereco (){
        return enderecoService.getAllEndereco();
    }

}
