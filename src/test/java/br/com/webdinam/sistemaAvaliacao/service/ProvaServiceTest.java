package br.com.webdinam.sistemaAvaliacao.service;

import br.com.webdinam.sistemaAvaliacao.dao.ProvaDAO;
import br.com.webdinam.sistemaAvaliacao.model.Prova;
import br.com.webdinam.sistemaAvaliacao.model.Questao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ProvaServiceTest {
    @Test
    public void testCriarProva() {
        // Cenário
        String nomeProva = "Prova de Matemática";
        List<Questao> questoes = new ArrayList<>(); // Adicione aqui as questões desejadas

        ProvaDAO provaDAO = new ProvaDAO(); // Crie uma instância real do DAO
        ProvaService provaService = new ProvaService(provaDAO); // Injete o DAO no serviço

        // Ação
        Prova prova = provaService.criarProva(nomeProva, questoes);

        // Verificação
        Assertions.assertNotNull(prova);
        Assertions.assertEquals(nomeProva, prova.getNome());
        Assertions.assertEquals(questoes.size(), prova.getQuestoes().size());
    }


}
