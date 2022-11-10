package br.com.bra.cofreinteligente.service;

import br.com.bra.cofreinteligente.dto.CofreDto;
import br.com.bra.cofreinteligente.entity.Cofre;
import br.com.bra.cofreinteligente.repository.CofreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CofreService {

    @Autowired
    public CofreRepository cofreRepository;

    @Autowired
    public ClienteFilialService clienteFilialService;

    @Autowired
    public SaldoCofreService saldoCofreService;

    public CofreDto addCofre (CofreDto dto) throws Exception {
        var cofre = Cofre.builder()
                .numeroCofre(dto.getNumeroCofre())
                .tipoCofre(dto.getTipoCofre())
                .clienteFilial(
                        clienteFilialService.findClienteFilial(dto.getIdClienteFilial()))
                .build();
        cofreRepository.save(cofre);
        saldoCofreService.addAbreSaldoCofre(cofre.getNumeroCofre());
        return new CofreDto(cofre);
    }

    public List<CofreDto> getAllCofre (){
        return cofreRepository.findAll()
                .stream()
                .map(CofreDto::new)
                .toList();
    }

    public CofreDto getCofreByNumCofre (Long numCofre) throws Exception {
        var cofre = cofreRepository.findById(numCofre);
        if(cofre.isEmpty()){
            throw new Exception("Cofre não localizado");
        }
        return new CofreDto(cofre.get());
    }

    public List<CofreDto> getAllCofreByIdCliente(Long idCliente) throws Exception {
        return cofreRepository.findAllByClienteFilial(clienteFilialService.findClienteFilial(idCliente))
                .stream()
                .map(CofreDto::new)
                .toList();
    }

    public void deleteCofreByNumCofre (Long numCofre) throws Exception {
        cofreRepository.deleteById(getCofreByNumCofre(numCofre).getNumeroCofre());
    }

    public CofreDto alteraTipoCofreByNumCofre(Long numCofre, String tipoCofre) throws Exception {
        var dto = cofreRepository.findById(numCofre);
        if(dto.isEmpty()){
            throw new Exception("Cofre não localizado");
        }
        var cofre = Cofre.builder()
                .tipoCofre(tipoCofre)
                .numeroCofre(dto.get().getNumeroCofre())
                .clienteFilial(dto.get().getClienteFilial())
                .build();
        cofreRepository.save(cofre);
        return new CofreDto(cofre);
    }

}
