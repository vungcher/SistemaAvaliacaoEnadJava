package br.com.webdinam.sistemaAvaliacao.service;

import br.com.webdinam.sistemaAvaliacao.dao.TipoUsuarioDao;
import br.com.webdinam.sistemaAvaliacao.model.TipoUsuario;
import br.com.webdinam.sistemaAvaliacao.model.Usuario;
import br.com.webdinam.sistemaAvaliacao.repository.TipoUsuarioRepository;
import br.com.webdinam.sistemaAvaliacao.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoUsuarioService {
    private final TipoUsuarioRepository tipoUsuarioRepository;

    @Autowired
    public TipoUsuarioService(TipoUsuarioRepository tipoUsuarioRepository) {
        this.tipoUsuarioRepository = tipoUsuarioRepository;
    }

    public TipoUsuario buscarTipoUsuarioPorId(int idTipoUsuario) {
        return tipoUsuarioRepository.findById(idTipoUsuario).orElse(null);
    }

    public List<TipoUsuario> listarTiposUsuario() {
        return tipoUsuarioRepository.findAll();
    }

    public void salvarTipoUsuario(TipoUsuario tipoUsuario) {
        tipoUsuarioRepository.save(tipoUsuario);
    }

    public void atualizarTipoUsuario(TipoUsuario tipoUsuario) {
        tipoUsuarioRepository.save(tipoUsuario);
    }

    public void excluirTipoUsuario(TipoUsuario tipoUsuario) {
        tipoUsuarioRepository.delete(tipoUsuario);
    }

    public List<TipoUsuario> getAllTiposUsuario() {
        return tipoUsuarioRepository.findAll();
    }

}
