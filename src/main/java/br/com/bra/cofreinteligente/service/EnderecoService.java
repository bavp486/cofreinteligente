package br.com.bra.cofreinteligente.service;

import br.com.bra.cofreinteligente.dto.ClienteMatrizDto;
import br.com.bra.cofreinteligente.entity.Endereco;
import br.com.bra.cofreinteligente.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    public EnderecoRepository enderecoRepository;



    public Endereco addEndereco(String rua, String numero, String cidade, String uf){
        var endereco = Endereco.builder()
                .rua(rua)
                .numero(numero)
                .cidade(cidade)
                .uf(uf)
                .build();
        return enderecoRepository.saveAndFlush(endereco);
    }

    public List<Endereco> getAllEndereco (){
        return enderecoRepository.findAll();
    }

}
