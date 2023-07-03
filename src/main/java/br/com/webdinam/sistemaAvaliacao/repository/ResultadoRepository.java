package br.com.webdinam.sistemaAvaliacao.repository;

import br.com.webdinam.sistemaAvaliacao.model.Resultado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultadoRepository extends JpaRepository<Resultado, Long> {
}
