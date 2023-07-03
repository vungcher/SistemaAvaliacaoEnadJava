package br.com.webdinam.sistemaAvaliacao.controller;

import br.com.webdinam.sistemaAvaliacao.model.TipoQuestao;
import br.com.webdinam.sistemaAvaliacao.service.TipoQuestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tipo-questao")
public class TipoQuestaoController {
    @Autowired
    private TipoQuestaoService tipoQuestaoService;

    @GetMapping
    public List<TipoQuestao> getAllTiposQuestao() {
        return tipoQuestaoService.getAllTiposQuestao();
    }

    // Implemente os demais métodos CRUD e as demais operações necessárias
}
