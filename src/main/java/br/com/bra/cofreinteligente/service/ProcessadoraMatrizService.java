package br.com.bra.cofreinteligente.service;

import br.com.bra.cofreinteligente.dto.ProcessadoraMatrizDto;
import br.com.bra.cofreinteligente.entity.Endereco;
import br.com.bra.cofreinteligente.entity.ProcessadoraMatriz;
import br.com.bra.cofreinteligente.repository.ProcessadoraMatrizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessadoraMatrizService {

    @Autowired
    public ProcessadoraMatrizRepository processadoraMatrizRepository;

    @Autowired
    public EnderecoService enderecoService;

    public ProcessadoraMatrizDto addProcessadoraMatriz (ProcessadoraMatrizDto dto){
        var endereco = Endereco.builder()
                .rua(dto.getEndereco().getRua())
                .numero(dto.getEndereco().getNumero())
                .cidade(dto.getEndereco().getCidade())
                .uf(dto.getEndereco().getUf())
                .build();
        var cliente = ProcessadoraMatriz.builder()
                .endereco(endereco)
                .cnpj(dto.getCnpj())
                .nome(dto.getNome())
                .build();
        processadoraMatrizRepository.save ( cliente );
        return new ProcessadoraMatrizDto (cliente);
    }

    public ProcessadoraMatrizDto getProcessadoraMatriz(Long id) throws Exception {
        var cliente = processadoraMatrizRepository.findById ( id );
        if (cliente.isEmpty ()){
            throw new Exception ("Cliente não localizado");
        }
        return new ProcessadoraMatrizDto (cliente.get ());
    }

    public List<ProcessadoraMatrizDto> getAllProcessadoraMatriz(){
        return processadoraMatrizRepository.findAll().stream()
                .map(ProcessadoraMatrizDto::new)
                .toList();
    }


//    public void delete(Long id) throws Exception {
//        processadoraMatrizRepository.deleteById(getProcessadoraMatriz ( id ).getId());
//    }

    public ProcessadoraMatrizDto alteraNomeClientePorId(Long id, ProcessadoraMatrizDto processadoraMatrizDto) throws Exception {
        var dto = processadoraMatrizRepository.findById(id);
        if(dto.isEmpty()){
            throw new Exception("Processadora não localizada");
        }
        var cliente = ProcessadoraMatriz.builder ()
                .id(dto.get().getId())
                .endereco(dto.get().getEndereco())
                .cnpj(processadoraMatrizDto.getCnpj())
                .nome(processadoraMatrizDto.getNome())
                .build();
        processadoraMatrizRepository.save(cliente);
        return new ProcessadoraMatrizDto (cliente);
    }

}
