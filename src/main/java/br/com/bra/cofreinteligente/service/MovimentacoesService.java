package br.com.bra.cofreinteligente.service;

import br.com.bra.cofreinteligente.dto.MovimentacoesDto;
import br.com.bra.cofreinteligente.entity.Movimentacoes;
import br.com.bra.cofreinteligente.repository.MovimentacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimentacoesService {

    @Autowired
    public MovimentacoesRepository movimentacoesRepository;

    @Autowired
    public CofreService cofreService;
    public MovimentacoesDto addMovimentacoes;

    public MovimentacoesDto novaMovimentacao(MovimentacoesDto movimentacoesDto){
        Movimentacoes movimentacao = Movimentacoes.builder()
                .id(movimentacoesDto.getId())
                .numero_cofre(movimentacoesDto.getNumero_cofre())
                .data(movimentacoesDto.getData())
                .valor_Recolhido(movimentacoesDto.getValor_Recolhido())
                .build();
            movimentacoesRepository.save(movimentacao);
        return new MovimentacoesDto(movimentacao);
    }

    public List<MovimentacoesDto> getAllMovimentacoes() {
        return null;
    }

    public MovimentacoesDto getMovimentacoes(Long id) {
        return null;
    }


}
