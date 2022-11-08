package br.com.bra.cofreinteligente.service;

import br.com.bra.cofreinteligente.dto.ProcessadoraMatrizDto;
import br.com.bra.cofreinteligente.entity.ProcessadoraMatriz;
import br.com.bra.cofreinteligente.repository.ProcessadoraMatrizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessadoraMatrizService {

    @Autowired
    public ProcessadoraMatrizRepository processadoraMatrizRepository;

    public ProcessadoraMatrizDto addProcessadoraMatriz (ProcessadoraMatrizDto processadoraMatrizDto){
        var cliente = ProcessadoraMatriz.builder()
                .id_endereco(processadoraMatrizDto.getId_endereco())
                .cnpj(processadoraMatrizDto.getCnpj())
                .nome(processadoraMatrizDto.getNome())
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


    public void delete(Long id) throws Exception {
        processadoraMatrizRepository.deleteById(getProcessadoraMatriz ( id ).getId());
    }

    public ProcessadoraMatrizDto alteraNomeClientePorId(Long id, ProcessadoraMatrizDto processadoraMatrizDto) throws Exception {
        var dto = getProcessadoraMatriz ( id );
        var cliente = ProcessadoraMatriz.builder ()
                .id(dto.getId())
                .id_endereco(dto.getId_endereco())
                .cnpj(processadoraMatrizDto.getCnpj())
                .nome(processadoraMatrizDto.getNome())
                .build();
        processadoraMatrizRepository.save(cliente);
        return new ProcessadoraMatrizDto (cliente);
    }

}
