package br.com.webdinam.sistemaAvaliacao.service;

import br.com.webdinam.sistemaAvaliacao.dao.QuestaoDao;
import br.com.webdinam.sistemaAvaliacao.model.Questao;
import br.com.webdinam.sistemaAvaliacao.repository.QuestaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class QuestaoService {

    private final QuestaoRepository questaoRepository;

    @Autowired
    public QuestaoService(QuestaoRepository questaoRepository) {
        this.questaoRepository = questaoRepository;
    }

    public List<Questao> findAll() {
        return questaoRepository.findAll();
    }

    public Questao findById(Integer id) {
        Optional<Questao> questaoOptional = questaoRepository.findById(id);
        return questaoOptional.orElse(null);
    }

    public void save(Questao questao) {
        questaoRepository.save(questao);
    }

    public void update(Questao questao) {
        questaoRepository.save(questao);
    }

    public void delete(Questao questao) {
        questaoRepository.delete(questao);
    }
}
