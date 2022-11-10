package br.com.bra.cofreinteligente.service;

import br.com.bra.cofreinteligente.dto.ClienteFilialDto;
import br.com.bra.cofreinteligente.dto.ClienteMatrizDto;
import br.com.bra.cofreinteligente.entity.ClienteFilial;
import br.com.bra.cofreinteligente.entity.ClienteMatriz;
import br.com.bra.cofreinteligente.entity.Endereco;
import br.com.bra.cofreinteligente.repository.ClienteMatrizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteMatrizService {

    @Autowired
    public ClienteMatrizRepository clienteMatrizRepository;

    @Autowired
    public EnderecoService enderecoService;

    public ClienteMatrizDto addClienteMatriz (ClienteMatrizDto dto){
        var endereco = Endereco.builder()
                .rua(dto.getEndereco().getRua())
                .numero(dto.getEndereco().getNumero())
                .cidade(dto.getEndereco().getCidade())
                .uf(dto.getEndereco().getUf())
                .build();

        var cliente = ClienteMatriz.builder()
                .endereco(endereco)
                .cnpj(dto.getCnpj())
                .nome(dto.getNome())
                .build();
        clienteMatrizRepository.save(cliente);
        return new ClienteMatrizDto(cliente);
    }

    public ClienteMatrizDto getClienteMatriz(Long id) throws Exception {
        var cliente = clienteMatrizRepository.findById(id);
        if (cliente.isEmpty()){
            throw new Exception("Cliente não localizado");
        }
        return new ClienteMatrizDto(cliente.get());
    }

    public List<ClienteMatrizDto> getAllClienteMatriz(){
        return clienteMatrizRepository.findAll().stream()
                .map(ClienteMatrizDto::new)
                .toList();
    }


    public void delete(Long id) throws Exception {
        clienteMatrizRepository.deleteById(getClienteMatriz(id).getId());
    }

    public ClienteMatrizDto alteraNomeClientePorId(Long id, ClienteMatrizDto clienteMatrizDto) throws Exception {
        var dto = clienteMatrizRepository.findById(id);
        if(dto.isEmpty()){
            throw new Exception("Cliente não localizado");
        }
        var cliente = ClienteMatriz.builder()
                .id(dto.get().getId())
                .endereco(dto.get().getEndereco())
                .cnpj(clienteMatrizDto.getCnpj())
                .nome(clienteMatrizDto.getNome())
                .build();
        clienteMatrizRepository.save(cliente);
        return new ClienteMatrizDto(cliente);
    }

}
