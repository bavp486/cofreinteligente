package br.com.bra.cofreinteligente.service;

import br.com.bra.cofreinteligente.dto.ClienteFilialDto;
import br.com.bra.cofreinteligente.dto.ClienteMatrizDto;
import br.com.bra.cofreinteligente.entity.ClienteFilial;
import br.com.bra.cofreinteligente.entity.ClienteMatriz;
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

        var cliente = ClienteMatriz.builder()
                .id_endereco(
                        enderecoService.addEndereco(dto.getEndereco().getRua(),dto.getEndereco().getNumero(),dto.getEndereco().getCidade(),dto.getEndereco().getUf()).getId())
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
        var dto = getClienteMatriz(id);
        var cliente = ClienteMatriz.builder()
                .id(dto.getId())
                .id_endereco(dto.getId_endereco())
                .cnpj(clienteMatrizDto.getCnpj())
                .nome(clienteMatrizDto.getNome())
                .build();
        clienteMatrizRepository.save(cliente);
        return new ClienteMatrizDto(cliente);
    }

}
