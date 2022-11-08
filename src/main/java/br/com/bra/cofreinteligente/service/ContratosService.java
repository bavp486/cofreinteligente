package br.com.bra.cofreinteligente.service;

import br.com.bra.cofreinteligente.dto.ContratosDto;
import br.com.bra.cofreinteligente.entity.Contratos;
import br.com.bra.cofreinteligente.repository.ContratosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ContratosService {

    @Autowired
    public ContratosRepository contratosRepository;

    @Autowired
    public ProcessadoraFilialService processadoraFilialService;

    @Autowired
    public ClienteFilialService clienteFilialService;

    public ContratosDto addContratos(ContratosDto dto) throws Exception {
        var contrato = Contratos.builder()
                .id_processadora(processadoraFilialService.getProcessadoraFilialbyCNPJ(dto.getId_processadora()))
                .numero_contrato(clienteFilialService.getClienteFilialbyNum_Contrato(dto.getNumero_contrato()))
                .valor(dto.getValor())
                .build();
        contratosRepository.save(contrato);
        return new ContratosDto(contrato);
    }

    public List<ContratosDto> getAllContratos(){
        return contratosRepository.findAll().stream()
                .map(ContratosDto::new)
                .toList();
    }

    public ContratosDto getContratosByiD (Long id) throws Exception {
        var contratos = contratosRepository.findById(id);
        if (contratos.isEmpty()){
            throw new Exception("Contrato não existente");
        }
        return new ContratosDto(contratos.get());
    }

    public void deleteContratos (Long id) throws Exception {
        contratosRepository.deleteById(getContratosByiD(id).getNumero_contrato());
    }

    public ContratosDto alteraValorContratoById(Long id, Long valor) throws Exception {
        var dto = getContratosByiD(id);
        var contrato = Contratos.builder()
                .numero_contrato(dto.getNumero_contrato())
                .id_processadora(dto.getId_processadora())
                .valor(BigDecimal.valueOf(valor))
                .build();
       contratosRepository.save(contrato);
        return new ContratosDto(contrato);
    }

}
