package br.com.bra.cofreinteligente.service;

import br.com.bra.cofreinteligente.dto.ClienteFilialDto;
import br.com.bra.cofreinteligente.entity.ClienteFilial;
import br.com.bra.cofreinteligente.repository.ClienteFilialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteFilialService {

    @Autowired
    private ClienteFilialRepository clienteFilialRepository;

    public ClienteFilialDto addClienteFilial(ClienteFilialDto clienteFilialDto){
        ClienteFilial cliente = ClienteFilial.builder()
                .id_Matriz(clienteFilialDto.getId_Matriz())
                .id_endereco(clienteFilialDto.getId_endereco())
                .id_conta(clienteFilialDto.getId_conta())
                .num_contrato(clienteFilialDto.getNum_contrato())
                .cnpj(clienteFilialDto.getCnpj())
                .nome(clienteFilialDto.getNome())
                .build();
        clienteFilialRepository.save(cliente);
        return new ClienteFilialDto(cliente);
    }

    public ClienteFilialDto getClienteFilial(Long id) throws Exception {
        var cliente = clienteFilialRepository.findById(id);
        if (cliente.isEmpty()){
            throw new Exception("Cliente não localizado");
        }
        return new ClienteFilialDto(cliente.get());
      //  return clienteFilialRepository.findById(id).get();
    }

    public List<ClienteFilialDto> getAllClienteFilial(){
        return clienteFilialRepository.findAll().stream()
                .map(ClienteFilialDto::new)
                .toList();

       // return clienteFilialRepository.findAll();
    }


    public void delete(Long id) throws Exception {
        clienteFilialRepository.deleteById(getClienteFilial(id).getId());
    }

    public ClienteFilialDto alteraNomeClientePorId(Long id, ClienteFilialDto clienteFilialDto) throws Exception {
        var dto = getClienteFilial(id);
        var cliente = ClienteFilial.builder()
                .id(dto.getId())
                .id_Matriz(dto.getId_Matriz())
                .id_endereco(dto.getId_endereco())
                .id_conta(dto.getId_conta())
                .num_contrato(dto.getNum_contrato())
                .cnpj(clienteFilialDto.getCnpj())
                .nome(clienteFilialDto.getNome())
                .build();
        clienteFilialRepository.save(cliente);
        return new ClienteFilialDto(cliente);
    }

}
