package br.com.webdinam.sistemaAvaliacao.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QuestaoTest {
    private Questao questao;

    @BeforeEach
    public void setUp() {
        questao = new Questao();
    }

    @Test
    public void testSetDescricaoQuestao() {
        // Cenário
        String descricao = "Qual a capital do Brasil?";

        // Ação
        questao.setDescricaoQuestao(descricao);

        // Verificação
        Assertions.assertEquals(descricao, questao.getDescricaoQuestao());
    }
}
