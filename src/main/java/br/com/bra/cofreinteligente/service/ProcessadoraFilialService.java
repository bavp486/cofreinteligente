package br.com.bra.cofreinteligente.service;

import br.com.bra.cofreinteligente.dto.ProcessadoraFilialDto;
import br.com.bra.cofreinteligente.entity.Endereco;
import br.com.bra.cofreinteligente.entity.ProcessadoraFilial;
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

    public ProcessadoraFilialDto addProcessadoraFilial (ProcessadoraFilialDto dto){
        var endereco = Endereco.builder()
                .rua(dto.getEndereco().getRua())
                .numero(dto.getEndereco().getNumero())
                .cidade(dto.getEndereco().getCidade())
                .uf(dto.getEndereco().getUf())
                .build();
        ProcessadoraFilial cliente = ProcessadoraFilial.builder()
                .id_Matriz(dto.getId_Matriz())
                .cnpj(dto.getCnpj())
                .endereco(endereco)
                .nome ( dto.getNome () )
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
        var endereco = Endereco.builder()
                .rua(processadoraFilialDto.getEndereco().getRua())
                .numero(processadoraFilialDto.getEndereco().getNumero())
                .cidade(processadoraFilialDto.getEndereco().getCidade())
                .uf(processadoraFilialDto.getEndereco().getUf())
                .build();
        var dto = getProcessadoraFilial (id);
        var cliente = ProcessadoraFilial.builder()
                .id(dto.getId())
                .id_Matriz(dto.getId_Matriz())
                .endereco(endereco)
                .cnpj(processadoraFilialDto.getCnpj())
                .nome(processadoraFilialDto.getNome())
                .build();
        processadoraFilialRepository.save(cliente);
        return new ProcessadoraFilialDto (cliente);
    }

    public Long getProcessadoraFilialbyCNPJ(Long id) throws Exception {
        var processadora = processadoraFilialRepository.findByCnpj(id);
        if (processadora.isEmpty()){
            throw new Exception("CNPJ não localizado nas Processadoras");
        }
        return processadora.stream().findFirst().get().getCnpj();
    }

}
