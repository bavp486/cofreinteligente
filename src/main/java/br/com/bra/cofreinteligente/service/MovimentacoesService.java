package br.com.bra.cofreinteligente.service;

import br.com.bra.cofreinteligente.dto.MovimentacoesDto;
import br.com.bra.cofreinteligente.entity.Cofre;
import br.com.bra.cofreinteligente.entity.Movimentacoes;
import br.com.bra.cofreinteligente.repository.CofreRepository;
import br.com.bra.cofreinteligente.repository.MovimentacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MovimentacoesService {

    @Autowired
    public MovimentacoesRepository movimentacoesRepository;

    @Autowired
    public CofreService cofreService;

    @Autowired
    public CofreRepository cofreRepository;

    @Autowired
    public SaldoCofreService saldoCofreService;

    @Autowired
    public  SaldoContaService saldoContaService;


    public MovimentacoesDto addMovimentacoes(MovimentacoesDto movimentacoesDto) throws Exception {
        var cofre = new Cofre();
        cofre.setNumeroCofre(movimentacoesDto.getNumeroCofre());
        Movimentacoes movimentacao = Movimentacoes.builder()
                .cofre(cofre)
                .data(LocalDate.now())
                .valorRecolhido(movimentacoesDto.getValorRecolhido())
                .build();
        movimentacoesRepository.save(movimentacao);
        saldoCofreService.addSaldoCofre(movimentacao);
        saldoContaService.addSaldoConta(movimentacao);
        return new MovimentacoesDto(movimentacao);
    }

    public List<MovimentacoesDto> getAllMovimentacoes() {
        return movimentacoesRepository.findAll().stream()
                .map(MovimentacoesDto::new)
                .toList();
    }

    public MovimentacoesDto getMovimentacoes(Long id) throws Exception {
        var movimentacao = movimentacoesRepository.findById(id);
        if (movimentacao.isEmpty()){
            throw new Exception("Movimentação não encontrada");
        }
        return new MovimentacoesDto(movimentacao.get());
    }

    public List<MovimentacoesDto> getAllByPeriod(String inicio, String fim){
        var dataIni = LocalDate.parse(inicio);
        var dataFim = LocalDate.parse(fim);
        return movimentacoesRepository.findByDataBetween(dataIni, dataFim)
                .stream()
                .map(MovimentacoesDto::new)
                .toList();
    }

    public List<MovimentacoesDto> getByPeriodAndCofre(String inicio, String fim, Long numeroCofre) throws Exception {
        var dataIni = LocalDate.parse(inicio);
        var dataFim = LocalDate.parse(fim);
        var cofre = cofreRepository.findById(numeroCofre);
        if(cofre.isEmpty()){
            throw new Exception("Cofre não localizado");
        }
        return movimentacoesRepository.findByDataBetweenAndCofre(dataIni, dataFim, cofre.get())
                .stream()
                .map(MovimentacoesDto::new)
                .toList();
    }

}