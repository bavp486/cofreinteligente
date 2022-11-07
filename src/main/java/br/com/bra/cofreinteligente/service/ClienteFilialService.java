package br.com.bra.cofreinteligente.service;

import br.com.bra.cofreinteligente.entity.ClienteFilial;
import br.com.bra.cofreinteligente.repository.ClienteFilialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteFilialService {

    @Autowired
    private ClienteFilialRepository clienteFilialRepository;

    public ClienteFilial addClienteFilial(ClienteFilial clienteFilial){
        return clienteFilialRepository.save(clienteFilial);
    }

    public ClienteFilial getClienteFilial(Long id){
        return clienteFilialRepository.getReferenceById(id);
    }

    public List<ClienteFilial> getAllClienteFilial(){
        return clienteFilialRepository.findAll();
    }


}
