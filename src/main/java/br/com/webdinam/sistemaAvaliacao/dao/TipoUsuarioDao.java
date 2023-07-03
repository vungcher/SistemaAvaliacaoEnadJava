
package br.com.webdinam.sistemaAvaliacao.dao;

import br.com.webdinam.sistemaAvaliacao.model.TipoUsuario;
import br.com.webdinam.sistemaAvaliacao.util.EntityManagerUtil;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class TipoUsuarioDao {

    public TipoUsuario salvar(TipoUsuario tipoUsuario) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(tipoUsuario);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        return tipoUsuario;
    }

    public TipoUsuario atualizar(TipoUsuario tipoUsuario) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(tipoUsuario);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        return tipoUsuario;
    }

    public void excluir(TipoUsuario tipoUsuario) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.remove(em.merge(tipoUsuario));
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public TipoUsuario buscarPorId(int id) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        TipoUsuario tipoUsuario = null;
        try {
            tipoUsuario = em.find(TipoUsuario.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return tipoUsuario;
    }

    public List<TipoUsuario> buscarTodos() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        List<TipoUsuario> tiposUsuario = null;
        try {
            TypedQuery<TipoUsuario> query = em.createQuery("SELECT tu FROM TipoUsuario tu", TipoUsuario.class);
            tiposUsuario = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return tiposUsuario;
    }
}
