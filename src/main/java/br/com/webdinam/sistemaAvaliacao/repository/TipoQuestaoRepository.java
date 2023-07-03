package br.com.webdinam.sistemaAvaliacao.repository;

import br.com.webdinam.sistemaAvaliacao.model.TipoQuestao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoQuestaoRepository extends JpaRepository<TipoQuestao, Integer> {
    TipoQuestao findByNome(String nome);

    long count();

    boolean existsByNome(String nome);

    void deleteByNome(String nome);

    List<TipoQuestao> findAllByOrderByNome();
    
    List<TipoQuestao> findAllByNomeContainingIgnoreCase(String descricao);

    List<TipoQuestao> findAllByNomeStartingWithIgnoreCase(String letra);
}
