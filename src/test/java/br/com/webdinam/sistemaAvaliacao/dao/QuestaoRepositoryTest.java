package br.com.webdinam.sistemaAvaliacao.dao;

import br.com.webdinam.sistemaAvaliacao.model.Questao;
import br.com.webdinam.sistemaAvaliacao.repository.QuestaoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class QuestaoRepositoryTest {
    @Autowired
    private QuestaoRepository questaoRepository;

    @Test
    public void testBuscarQuestaoPorId() {
        // Cenário
        int idQuestao = 1;

        // Ação
        Questao questao = questaoRepository.findById(idQuestao).orElse(null);

        // Verificação
        Assertions.assertNotNull(questao);
        Assertions.assertEquals("Qual a capital do Brasil?", questao.getDescricaoQuestao());
    }
}
