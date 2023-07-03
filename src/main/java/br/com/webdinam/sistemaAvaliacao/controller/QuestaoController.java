package br.com.webdinam.sistemaAvaliacao.controller;

import br.com.webdinam.sistemaAvaliacao.model.Questao;
import br.com.webdinam.sistemaAvaliacao.service.ProvaService;
import br.com.webdinam.sistemaAvaliacao.service.QuestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questao")
public class QuestaoController {
    private final QuestaoService questaoService;

    @Autowired
    public QuestaoController(QuestaoService questaoService) {
        this.questaoService = questaoService;
    }

    @GetMapping
    public List<Questao> getAllQuestoes() {
        return questaoService.findAll();
    }

    @GetMapping("/{id}")
    public Questao getQuestaoById(@PathVariable("id") Integer id) {
        return questaoService.findById(id);
    }

    @PostMapping
    public void createQuestao(@RequestBody Questao questao) {
        // Lógica de validação ou regras de negócio antes de criar a questão

        questaoService.save(questao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateQuestao(@PathVariable("id") Integer id, @RequestBody Questao questao) {
        // Lógica de validação ou regras de negócio antes de atualizar a questão

        Questao questaoExistente = questaoService.findById(id);
        if (questaoExistente != null) {
            questaoExistente.setDescricaoQuestao(questao.getDescricaoQuestao());
            questaoExistente.setQuestaoCorreta(questao.getQuestaoCorreta());
            questaoService.update(questaoExistente);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteQuestao(@PathVariable("id") int id) {
        // Lógica de validação ou regras de negócio antes de excluir a questão

        Questao questao = questaoService.findById(id);
        if (questao != null) {
            questaoService.delete(questao);
        }
    }

}
