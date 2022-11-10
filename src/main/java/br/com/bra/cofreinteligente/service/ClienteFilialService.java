package br.com.bra.cofreinteligente.service;

import br.com.bra.cofreinteligente.dto.ClienteFilialDto;
import br.com.bra.cofreinteligente.entity.*;
import br.com.bra.cofreinteligente.repository.ClienteFilialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
public class ClienteFilialService {

    @Autowired
    private ClienteFilialRepository clienteFilialRepository;

    @Autowired
    public EnderecoService enderecoService;

    @Autowired
    public ContaService contaService;

    @Autowired
    public  SaldoContaService saldoContaService;



    public ClienteFilialDto addClienteFilial(ClienteFilialDto dto){
        var endereco = Endereco.builder()
                .rua(dto.getEndereco().getRua())
                .numero(dto.getEndereco().getNumero())
                .cidade(dto.getEndereco().getCidade())
                .uf(dto.getEndereco().getUf())
                .build();


        var conta = Conta.builder()
                .conta(dto.getConta().getConta())
                .agencia(dto.getConta().getAgencia())
                .build();


        var clienteMatriz = new ClienteMatriz();
        clienteMatriz.setId(dto.getIdMatriz());
        ClienteFilial cliente = ClienteFilial.builder()
                .clienteMatriz(clienteMatriz)
                .endereco(endereco)
                .conta(conta)
                .cnpj(dto.getCnpj())
                .nome(dto.getNome())
                .build();
        clienteFilialRepository.save(cliente);
        saldoContaService.addAbreSaldoConta(cliente.getConta().getId());
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
        var dto = clienteFilialRepository.findById(id);
        if (dto.isEmpty()){
            throw new Exception("Cliente não localizado");
        }
        var cliente = ClienteFilial.builder()
                .id(dto.get().getId())
                .clienteMatriz(dto.get().getClienteMatriz())
                .endereco(dto.get().getEndereco())
                .conta(dto.get().getConta())
                .cnpj(clienteFilialDto.getCnpj())
                .nome(clienteFilialDto.getNome())
                .build();
        clienteFilialRepository.save(cliente);
        return new ClienteFilialDto(cliente);
    }

//    public Long getClienteFilialbyNum_Contrato (Long num_contrato) throws Exception {
//
//        var cliente = clienteFilialRepository.findAllByContratos(num_contrato);
//        if (cliente.isEmpty()){
//            throw new Exception("Numero do contrato não existe no cliente");
//        }
//        return cliente.stream().findFirst().get().getNumcontrato() ;
//    }

    public ClienteFilial findClienteFilial(Long id) throws Exception {
        var cliente = clienteFilialRepository.findById(id);
        if (cliente.isEmpty()){
            throw new Exception("Cliente não localizado");
        }
        return cliente.get();
        //  return clienteFilialRepository.findById(id).get();
    }
}
