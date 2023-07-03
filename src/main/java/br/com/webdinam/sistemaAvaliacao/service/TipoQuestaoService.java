package br.com.webdinam.sistemaAvaliacao.service;

import br.com.webdinam.sistemaAvaliacao.model.TipoQuestao;
import br.com.webdinam.sistemaAvaliacao.repository.TipoQuestaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoQuestaoService {
    @Autowired
    private TipoQuestaoRepository tipoQuestaoRepository;

    public List<TipoQuestao> getAllTiposQuestao() {
        return tipoQuestaoRepository.findAll();
    }

    public TipoQuestao getTipoQuestaoById(int id) {
        return tipoQuestaoRepository.findById(id).orElse(null);
    }

    public TipoQuestao saveTipoQuestao(TipoQuestao tipoQuestao) {
        return tipoQuestaoRepository.save(tipoQuestao);
    }

    public void deleteTipoQuestao(int id) {
        tipoQuestaoRepository.deleteById(id);
    }

    // Implemente os demais métodos e operações necessárias
}
