package br.com.bra.cofreinteligente.service;

import br.com.bra.cofreinteligente.dto.ContratosDto;
import br.com.bra.cofreinteligente.entity.ClienteFilial;
import br.com.bra.cofreinteligente.entity.Contratos;
import br.com.bra.cofreinteligente.entity.ProcessadoraFilial;
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

        var cliente = clienteFilialService.findClienteFilial(dto.getIdCliente());
        var processadora = processadoraFilialService.findProcessadoraFilial(dto.getIdProcessadora());
        var contrato = Contratos.builder()
                .numeroContrato(dto.getNumeroContrato())
                .processadoraFilial(processadora)
                .clienteFilial(cliente)
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
        contratosRepository.deleteById(getContratosByiD(id).getNumeroContrato());
    }

    public ContratosDto alteraValorContratoById(Long id, Long valor) throws Exception {
        var dto = contratosRepository.findById(id);
        if (dto.isEmpty()){
            throw new Exception("Contrato não localizado");
        }
        var contrato = Contratos.builder()
                .numeroContrato(dto.get().getNumeroContrato())
                .processadoraFilial(dto.get().getProcessadoraFilial())
                .clienteFilial(dto.get().getClienteFilial())
                .valor(BigDecimal.valueOf(valor))
                .build();
       contratosRepository.save(contrato);
        return new ContratosDto(contrato);
    }

}
