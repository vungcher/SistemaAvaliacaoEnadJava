package br.com.webdinam.sistemaAvaliacao.dao;

import br.com.webdinam.sistemaAvaliacao.model.TipoQuestao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TipoQuestaoDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<TipoQuestao> findAll() {
        return entityManager.createQuery("SELECT t FROM TipoQuestao t", TipoQuestao.class)
                .getResultList();
    }

    public TipoQuestao findById(int id) {
        return entityManager.find(TipoQuestao.class, id);
    }

    public void save(TipoQuestao tipoQuestao) {
        entityManager.persist(tipoQuestao);
    }

    public void update(TipoQuestao tipoQuestao) {
        entityManager.merge(tipoQuestao);
    }

    public void delete(TipoQuestao tipoQuestao) {
        entityManager.remove(tipoQuestao);
    }
}
