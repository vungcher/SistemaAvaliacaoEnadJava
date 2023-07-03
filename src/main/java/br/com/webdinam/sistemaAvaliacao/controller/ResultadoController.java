package br.com.webdinam.sistemaAvaliacao.controller;

import br.com.webdinam.sistemaAvaliacao.model.Resultado;
import br.com.webdinam.sistemaAvaliacao.service.ResultadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resultado")
public class ResultadoController {
    private final ResultadoService resultadoService;

    @Autowired
    public ResultadoController(ResultadoService resultadoService) {
        this.resultadoService = resultadoService;
    }

    @GetMapping
    public List<Resultado> getAllResultados() {
        return resultadoService.obterTodosResultados();
    }

    @GetMapping("/{id}")
    public Resultado getResultadoById(@PathVariable long id) {
        return resultadoService.obterResultadoPorId(id);
    }

    @PostMapping
    public void salvarResultado(@RequestBody Resultado resultado) {
        resultadoService.salvarResultado(resultado);
    }

    @PutMapping("/{id}")
    public void atualizarResultado(@PathVariable long id, @RequestBody Resultado resultado) {
        Resultado resultadoExistente = resultadoService.obterResultadoPorId(id);
        if (resultadoExistente != null) {
            resultado.setId(id);
            resultadoService.atualizarResultado(resultado);
        }
    }

    @DeleteMapping("/{id}")
    public void excluirResultado(@PathVariable long id) {
        Resultado resultadoExistente = resultadoService.obterResultadoPorId(id);
        if (resultadoExistente != null) {
            resultadoService.excluirResultado(resultadoExistente);
        }
    }
}
