package br.com.webdinam.sistemaAvaliacao.service;

import br.com.webdinam.sistemaAvaliacao.model.Usuario;
import br.com.webdinam.sistemaAvaliacao.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario buscarUsuarioPorId(int idUsuario) {
        return usuarioRepository.findById(idUsuario).orElse(null);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public void salvarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public void atualizarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public void excluirUsuario(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }
}
