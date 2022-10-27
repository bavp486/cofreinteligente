package br.com.bra.cofreinteligente.repository;

import br.com.bra.cofreinteligente.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}