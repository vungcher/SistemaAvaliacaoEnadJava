package br.com.webdinam.sistemaAvaliacao.model;

//import jakarta.persistence.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tipoUsuario")
public class TipoUsuario {

    @Id
    private int idTipoUsuario;
    private String nomeUsuario;

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public void salvar() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistemaAvaliacaoPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(this);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }

    // Método para atualizar o tipo de usuário no banco de dados
    public void atualizar() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistemaAvaliacaoPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.merge(this);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }

    // Método para excluir o tipo de usuário do banco de dados
    public void excluir() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistemaAvaliacaoPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            TipoUsuario tipoUsuario = em.find(TipoUsuario.class, this.idTipoUsuario);
            em.remove(tipoUsuario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }

    // Método para buscar um tipo de usuário pelo ID
    public static TipoUsuario buscarPorId(int idTipoUsuario) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistemaAvaliacaoPU");
        EntityManager em = emf.createEntityManager();

        TipoUsuario tipoUsuario = em.find(TipoUsuario.class, idTipoUsuario);

        em.close();
        emf.close();

        return tipoUsuario;
    }

    // Método para listar todos os tipos de usuários
    public static List<TipoUsuario> listarTodos() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistemaAvaliacaoPU");
        EntityManager em = emf.createEntityManager();

        TypedQuery<TipoUsuario> query = em.createQuery("SELECT tu FROM TipoUsuario tu", TipoUsuario.class);
        List<TipoUsuario> tiposUsuario = query.getResultList();

        em.close();
        emf.close();

        return tiposUsuario;
    }

}
