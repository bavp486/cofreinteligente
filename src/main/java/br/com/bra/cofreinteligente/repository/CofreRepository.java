package br.com.bra.cofreinteligente.repository;

import br.com.bra.cofreinteligente.entity.ClienteFilial;
import br.com.bra.cofreinteligente.entity.Cofre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CofreRepository extends JpaRepository<Cofre, Long> {

    List<Cofre> findAllByClienteFilial (ClienteFilial clienteFilial);

}