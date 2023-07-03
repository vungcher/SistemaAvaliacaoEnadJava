package br.com.webdinam.sistemaAvaliacao.repository;

import br.com.webdinam.sistemaAvaliacao.model.Questao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestaoRepository extends JpaRepository<Questao, Integer> {
}
