package br.com.webdinam.sistemaAvaliacao.repository;

import br.com.webdinam.sistemaAvaliacao.model.TipoQuestao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoQuestaoRepository extends JpaRepository<TipoQuestao, Integer> {
    TipoQuestao findByNome(String nome);

    // Método para contar o número total de tipos de questão
    long count();

    // Método para verificar se um tipo de questão existe pelo nome
    boolean existsByNome(String nome);

    // Método para excluir um tipo de questão pelo nome
    void deleteByNome(String nome);

    // Método para encontrar todos os tipos de questão com o nome ordenado
    List<TipoQuestao> findAllByOrderByNome();

    // Método para encontrar todos os tipos de questão que tenham a descrição fornecida no nome
    List<TipoQuestao> findAllByNomeContainingIgnoreCase(String descricao);

    // Método para encontrar todos os tipos de questão que tenham o nome começando com a letra fornecida
    List<TipoQuestao> findAllByNomeStartingWithIgnoreCase(String letra);
}
