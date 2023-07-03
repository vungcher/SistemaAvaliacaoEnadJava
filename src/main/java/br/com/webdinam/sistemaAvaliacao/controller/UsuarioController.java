package br.com.webdinam.sistemaAvaliacao.controller;

import br.com.webdinam.sistemaAvaliacao.model.Usuario;
import br.com.webdinam.sistemaAvaliacao.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    // Implemente os demais métodos CRUD e as demais operações necessárias
}
