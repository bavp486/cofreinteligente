package br.com.bra.cofreinteligente.Utils;


import br.com.bra.cofreinteligente.entity.Movimentacoes;
import br.com.bra.cofreinteligente.repository.MovimentacoesRepository;
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
           throw new Exception("Error While writing CSV ", e);
        }
    }
}
