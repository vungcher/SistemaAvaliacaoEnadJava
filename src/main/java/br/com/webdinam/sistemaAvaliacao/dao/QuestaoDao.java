package br.com.webdinam.sistemaAvaliacao.dao;


import br.com.webdinam.sistemaAvaliacao.model.Questao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class QuestaoDao {
    private EntityManager entityManager;

    public QuestaoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Questao findById(int id) {
        return entityManager.find(Questao.class, id);
    }

    public List<Questao> findAll() {
        TypedQuery<Questao> query = entityManager.createQuery("SELECT q FROM Questao q", Questao.class);
        return query.getResultList();
    }

    public void save(Questao questao) {
        entityManager.getTransaction().begin();
        entityManager.persist(questao);
        entityManager.getTransaction().commit();
    }

    public void update(Questao questao) {
        entityManager.getTransaction().begin();
        entityManager.merge(questao);
        entityManager.getTransaction().commit();
    }

    public void delete(Questao questao) {
        entityManager.getTransaction().begin();
        entityManager.remove(questao);
        entityManager.getTransaction().commit();
    }
}
