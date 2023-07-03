package br.com.webdinam.sistemaAvaliacao.repository;

import br.com.webdinam.sistemaAvaliacao.model.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer> {
}
