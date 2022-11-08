package br.com.bra.cofreinteligente.service;

import br.com.bra.cofreinteligente.dto.CofreDto;
import br.com.bra.cofreinteligente.repository.CofreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CofreService {

    @Autowired
    public CofreRepository cofreRepository;

    @Autowired
    public ClienteFilialService clienteFilialService;


    public CofreDto getCofreByNumero_Cofre(Long numero_cofre) throws Exception {
        var cofre = cofreRepository.findById(numero_cofre);
        if (cofre.isEmpty()){
            throw new Exception("Cofre inexistente");
        }
        return new CofreDto(cofre.get());
    }
}

