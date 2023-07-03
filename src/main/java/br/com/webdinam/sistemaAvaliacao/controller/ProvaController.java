package br.com.webdinam.sistemaAvaliacao.controller;

import br.com.webdinam.sistemaAvaliacao.model.Prova;
import br.com.webdinam.sistemaAvaliacao.service.ProvaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prova")
public class ProvaController {
    private final ProvaService provaService;

    @Autowired
    public ProvaController(ProvaService provaService) {
        this.provaService = provaService;
    }

    @GetMapping
    public List<Prova> getAllProvas() {
        return provaService.listarTodasProvas();
    }

    @GetMapping("/{id}")
    public Prova getProvaById(@PathVariable("id") Long id) {
        return provaService.buscarProvaPorId(id);
    }

    @PostMapping
    public Prova createProva(@RequestBody Prova prova) {
        // Lógica de validação ou regras de negócio antes de criar a prova

        return provaService.criarProva(prova.getNome(), prova.getQuestoes());
    }

    @PutMapping("/{id}")
    public void updateProva(@PathVariable("id") Long id, @RequestBody Prova prova) {
        // Lógica de validação ou regras de negócio antes de atualizar a prova

        Prova provaExistente = provaService.buscarProvaPorId(id);
        if (provaExistente != null) {
            provaExistente.setNome(prova.getNome());
            provaExistente.setQuestoes(prova.getQuestoes());
            provaService.atualizarProva(provaExistente);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteProva(@PathVariable("id") Long id) {
        // Lógica de validação ou regras de negócio antes de excluir a prova

        Prova prova = provaService.buscarProvaPorId(id);
        if (prova != null) {
            provaService.excluirProva(prova);
        }
    }



}
