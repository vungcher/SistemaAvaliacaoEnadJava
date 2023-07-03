package br.com.webdinam.sistemaAvaliacao.service;

import br.com.webdinam.sistemaAvaliacao.dao.ResultadoDAO;
import br.com.webdinam.sistemaAvaliacao.model.Resultado;
import br.com.webdinam.sistemaAvaliacao.repository.ResultadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ResultadoService {
    private final ResultadoRepository resultadoRepository;

    @Autowired
    public ResultadoService(ResultadoRepository resultadoRepository) {
        this.resultadoRepository = resultadoRepository;
    }

    public Resultado obterResultadoPorId(long id) {
        Optional<Resultado> optionalResultado = resultadoRepository.findById(id);
        return optionalResultado.orElse(null);
    }

    public List<Resultado> obterTodosResultados() {
        return resultadoRepository.findAll();
    }

    public void salvarResultado(Resultado resultado) {
        resultadoRepository.save(resultado);
    }

    public void atualizarResultado(Resultado resultado) {
        resultadoRepository.save(resultado);
    }

    public void excluirResultado(Resultado resultado) {
        resultadoRepository.delete(resultado);
    }
}

