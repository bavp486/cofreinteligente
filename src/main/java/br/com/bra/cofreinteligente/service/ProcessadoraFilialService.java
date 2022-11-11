package br.com.bra.cofreinteligente.service;

import br.com.bra.cofreinteligente.dto.ProcessadoraFilialDto;
import br.com.bra.cofreinteligente.entity.ClienteMatriz;
import br.com.bra.cofreinteligente.entity.Endereco;
import br.com.bra.cofreinteligente.entity.ProcessadoraFilial;
import br.com.bra.cofreinteligente.entity.ProcessadoraMatriz;
import br.com.bra.cofreinteligente.repository.ProcessadoraFilialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessadoraFilialService {

    @Autowired
    private ProcessadoraFilialRepository processadoraFilialRepository;

    @Autowired
    public EnderecoService enderecoService;

    public ProcessadoraFilialDto addProcessadoraFilial(ProcessadoraFilialDto dto) {

        var endereco = Endereco.builder()
                .rua(dto.getEndereco().getRua())
                .numero(dto.getEndereco().getNumero())
                .cidade(dto.getEndereco().getCidade())
                .uf(dto.getEndereco().getUf())
                .build();
        var processadoraMatriz = new ProcessadoraMatriz();
        processadoraMatriz.setId(dto.getId_Matriz());
        ProcessadoraFilial cliente = ProcessadoraFilial.builder()
                .processadoraMatriz(processadoraMatriz)
                .cnpj(dto.getCnpj())
                .endereco(endereco)
                .nome(dto.getNome())
                .build();
        processadoraFilialRepository.save(cliente);
        return new ProcessadoraFilialDto(cliente);
    }

    public ProcessadoraFilialDto getProcessadoraFilial(Long id) throws Exception {
        var cliente = processadoraFilialRepository.findById(id);
        if (cliente.isEmpty()) {
            throw new Exception("Processadora não localizada");
        }
        return new ProcessadoraFilialDto(cliente.get());
    }

    public List<ProcessadoraFilialDto> getAllProcessadoraFilial() {
        return processadoraFilialRepository.findAll().stream()
                .map(ProcessadoraFilialDto::new)
                .toList();

    }


//    public void delete(Long id) throws Exception {
//        processadoraFilialRepository.deleteById(getProcessadoraFilial(id).getId());
//    }

    public ProcessadoraFilialDto alteraNomeProcessadoraFilialPorId(Long id, ProcessadoraFilialDto processadoraFilialDto) throws Exception {
        var dto = processadoraFilialRepository.findById(id);
        if(dto.isEmpty()){
            throw new Exception("Processadora não localizada");
        }
        var cliente = ProcessadoraFilial.builder()
                .id(dto.get().getId())
                .processadoraMatriz(dto.get().getProcessadoraMatriz())
                .endereco(dto.get().getEndereco())
                .cnpj(processadoraFilialDto.getCnpj())
                .nome(processadoraFilialDto.getNome())
                .build();
        processadoraFilialRepository.save(cliente);
        return new ProcessadoraFilialDto(cliente);
    }

    public String getProcessadoraFilialbyCNPJ(Long id) throws Exception {
        var processadora = processadoraFilialRepository.findByCnpj(id);
        if (processadora.isEmpty()) {
            throw new Exception("CNPJ não localizado nas Processadoras");
        }
        return processadora.stream().findFirst().get().getCnpj();
    }
    public ProcessadoraFilial findProcessadoraFilial(Long id) throws Exception {
        var cliente = processadoraFilialRepository.findById(id);
        if (cliente.isEmpty()) {
            throw new Exception("Processadora não localizada");
        }
        return cliente.get();
    }
}
