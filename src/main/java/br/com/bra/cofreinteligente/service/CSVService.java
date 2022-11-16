package br.com.bra.cofreinteligente.service;


import br.com.bra.cofreinteligente.entity.Cofre;
import br.com.bra.cofreinteligente.entity.Movimentacoes;
import br.com.bra.cofreinteligente.entity.SaldoCofre;
import br.com.bra.cofreinteligente.entity.SaldoConta;
import br.com.bra.cofreinteligente.repository.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.*;
import java.util.List;


@Service
public class CSVService {

    @Autowired
    public MovimentacoesRepository movimentacoesRepository;

    @Autowired
    public SaldoContaRepository saldoContaRepository;

    @Autowired
    public SaldoCofreRepository saldoCofreRepository;

    @Autowired
    public ClienteFilialRepository clienteFilialRepository;

    @Autowired
    public CofreRepository cofreRepository;

    public void writeMovimentacaoToCsv(Writer writer) throws Exception {
        List<Movimentacoes> movimentacoes = movimentacoesRepository.findAll();
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            csvPrinter.printRecord("Cliente","NumeroCofre","Data","Valor");
            for (Movimentacoes movimentacao : movimentacoes) {
                csvPrinter.printRecord(
                        movimentacao.getCofre().getClienteFilial().getNome(),
                        movimentacao.getCofre().getNumeroCofre(),
                        movimentacao.getData(),
                        movimentacao.getValorRecolhido());
            }
        } catch (IOException e) {
           throw new Exception("Erro ao escrever CSV", e);
        }
    }
    public void writeMovimentacaoByClienteToCsv(Writer writer, Long id) throws Exception {
        var cliente = clienteFilialRepository.findById(id);
        if (cliente.isEmpty()){
            throw new Exception("Cliente não localizado");
        }
        var cofres = cofreRepository.findAllByClienteFilial(cliente.get());

        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            csvPrinter.printRecord("Cliente", "NumeroCofre", "Data", "Valor");
             for (Cofre cofre: cofres) {
                 var movimentacoes = movimentacoesRepository.findByCofre(cofre);
                 for (Movimentacoes movimentacao : movimentacoes) {
                     csvPrinter.printRecord(
                             movimentacao.getCofre().getClienteFilial().getNome(),
                             movimentacao.getCofre().getNumeroCofre(),
                             movimentacao.getData(),
                             movimentacao.getValorRecolhido());
                 }
             }
        } catch (IOException e) {
            throw new Exception("Erro ao escrever CSV", e);
        }
    }

    public void writeSaldoContaByCliente(Writer writer, Long id) throws Exception {
        var cliente = clienteFilialRepository.findById(id);
        if (cliente.isEmpty()) {
            throw new Exception("Cliente não licalizado");
        }
        var conta = cliente.get().getConta();
        var saldoContas = saldoContaRepository.findByConta(conta);
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            csvPrinter.printRecord("Cliente", "Agencia", "Conta", "Data", "Saldo");
            for (SaldoConta saldoConta : saldoContas) {
                csvPrinter.printRecord(
                        cliente.get().getNome(),
                        saldoConta.getConta().getAgencia(),
                        saldoConta.getConta().getConta(),
                        saldoConta.getData(),
                        saldoConta.getSaldo());
            }
        } catch (IOException e) {
            throw new Exception("Erro ao escrever CSV", e);
        }
    }
        public void writeSaldoCofreByCliente(Writer writer, Long id) throws Exception {
            var cliente = clienteFilialRepository.findById(id);
            if (cliente.isEmpty()) {
                throw new Exception("Cliente não licalizado");
            }
            var cofres =cofreRepository.findAllByClienteFilial(cliente.get());
            try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
                csvPrinter.printRecord("Cliente", "NumeroCofre", "Data", "Saldo");
                for (Cofre cofre: cofres) {
                    var saldoCofres = saldoCofreRepository.findByCofre(cofre);
                    for (SaldoCofre saldoCofre: saldoCofres){
                        csvPrinter.printRecord(
                                cliente.get().getNome(),
                                saldoCofre.getCofre().getNumeroCofre(),
                                saldoCofre.getData(),
                                saldoCofre.getSaldo());
                    }
                }
            } catch (IOException e) {
                throw new Exception("Erro ao escrever CSV", e);
            }
    }
}
