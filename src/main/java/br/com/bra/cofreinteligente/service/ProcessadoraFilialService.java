package br.com.bra.cofreinteligente.service;

import br.com.bra.cofreinteligente.dto.ProcessadoraFilialDto;
import br.com.bra.cofreinteligente.entity.ProcessadoraFilial;
import br.com.bra.cofreinteligente.repository.ProcessadoraFilialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessadoraFilialService {

    @Autowired
    private ProcessadoraFilialRepository processadoraFilialRepository;

    public ProcessadoraFilialDto addProcessadoraFilial (ProcessadoraFilialDto processadoraFilialDto){
        ProcessadoraFilial cliente = ProcessadoraFilial.builder()
                .id_Matriz(processadoraFilialDto.getId_Matriz())
                .id_endereco( processadoraFilialDto.getId_endereco ())
                .cnpj ( processadoraFilialDto.getCnpj () )
                .nome ( processadoraFilialDto.getNome () )
                .build();
        processadoraFilialRepository.save(cliente);
        return new ProcessadoraFilialDto (cliente);
    }

    public ProcessadoraFilialDto getProcessadoraFilial(Long id) throws Exception {
        var cliente = processadoraFilialRepository.findById(id);
        if (cliente.isEmpty()){
            throw new Exception("Cliente não localizado");
        }
        return new ProcessadoraFilialDto (cliente.get());
    }

    public List<ProcessadoraFilialDto> getAllProcessadoraFilial(){
        return processadoraFilialRepository.findAll().stream()
                .map(ProcessadoraFilialDto::new)
                .toList();

    }


    public void delete(Long id) throws Exception {
        processadoraFilialRepository.deleteById(getProcessadoraFilial ( id ).getId());
    }

    public ProcessadoraFilialDto alteraNomeProcessadoraFilialPorId(Long id, ProcessadoraFilialDto processadoraFilialDto) throws Exception {
        var dto = getProcessadoraFilial (id);
        var cliente = ProcessadoraFilial.builder()
                .id(dto.getId())
                .id_Matriz(dto.getId_Matriz())
                .id_endereco(dto.getId_endereco())
                .cnpj(processadoraFilialDto.getCnpj())
                .nome(processadoraFilialDto.getNome())
                .build();
        processadoraFilialRepository.save(cliente);
        return new ProcessadoraFilialDto (cliente);
    }

}
