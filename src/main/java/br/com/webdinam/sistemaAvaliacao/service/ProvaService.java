
package br.com.webdinam.sistemaAvaliacao.service;

import br.com.webdinam.sistemaAvaliacao.dao.ProvaDAO;
import br.com.webdinam.sistemaAvaliacao.model.Prova;
import br.com.webdinam.sistemaAvaliacao.model.Questao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvaService {
    private final ProvaDAO provaDAO;

    @Autowired
    public ProvaService(ProvaDAO provaDAO) {
        this.provaDAO = provaDAO;
    }

    public Prova criarProva(String nome, List<Questao> questoes) {
        Prova prova = new Prova();
        prova.setNome(nome);
        prova.setQuestoes(questoes);
        provaDAO.criar(prova);
        return prova;
    }

    public Prova buscarProvaPorId(Long id) {
        return provaDAO.buscarPorId(id);
    }

    public void atualizarProva(Prova prova) {
        
        provaDAO.atualizar(prova);
    }

    public void excluirProva(Prova prova) {
     
        provaDAO.excluir(prova);
    }

    public List<Prova> listarTodasProvas() {
        return provaDAO.listarTodos();
    }



    public void fecharConexao() {
        provaDAO.fecharConexao();
    }
}

