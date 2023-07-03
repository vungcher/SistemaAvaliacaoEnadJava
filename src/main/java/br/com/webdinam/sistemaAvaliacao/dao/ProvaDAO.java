package br.com.webdinam.sistemaAvaliacao.dao;
import br.com.webdinam.sistemaAvaliacao.model.Prova;

import javax.persistence.*;
import java.util.List;

public class ProvaDAO {
    private EntityManagerFactory emf;

    public ProvaDAO() {
        emf = Persistence.createEntityManagerFactory("nome_da_unidade_de_persistencia");
    }

    public void criar(Prova prova) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        try {
            em.persist(prova);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Prova buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Prova prova = null;

        try {
            prova = em.find(Prova.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return prova;
    }

    public void atualizar(Prova prova) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        try {
            em.merge(prova);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void excluir(Prova prova) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        try {
            em.remove(prova);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Prova> listarTodos() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Prova> query = em.createQuery("SELECT p FROM Prova p", Prova.class);
        List<Prova> provas = query.getResultList();
        em.close();

        return provas;
    }

    // Outros métodos conforme necessário

    public void fecharConexao() {
        emf.close();
    }

    public void criarProva(Prova prova) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(prova);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}

