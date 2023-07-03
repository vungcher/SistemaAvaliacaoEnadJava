package br.com.webdinam.sistemaAvaliacao.dao;

import br.com.webdinam.sistemaAvaliacao.model.TipoUsuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TipoUsuarioDaoTest {
    @Test
    public void testBuscarTipoUsuarioPorId() {
        // Cenário
        int idTipoUsuario = 1;
        TipoUsuarioDao tipoUsuarioDAO = new TipoUsuarioDao();

        // Ação
        TipoUsuario tipoUsuario = tipoUsuarioDAO.buscarPorId(idTipoUsuario);

        // Verificação
        Assertions.assertEquals("Aluno", tipoUsuario.getNomeUsuario());
    }

}
