package br.com.webdinam.sistemaAvaliacao.model;

//import jakarta.persistence.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "resultado")
public class Resultado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "prova_id")
    private Prova prova;

    private int pontuacao;

    @Column(name = "data_realizacao")
    private LocalDate dataRealizacao;

    public Resultado() {
    }

    public Resultado(Usuario usuario, Prova prova, int pontuacao, LocalDate dataRealizacao) {
        this.usuario = usuario;
        this.prova = prova;
        this.pontuacao = pontuacao;
        this.dataRealizacao = dataRealizacao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Prova getProva() {
        return prova;
    }

    public void setProva(Prova prova) {
        this.prova = prova;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public LocalDate getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(LocalDate dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }

    public void salvar() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("nome_da_unidade_de_persistencia");
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

    public void atualizar() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("nome_da_unidade_de_persistencia");
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

    public void excluir() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("nome_da_unidade_de_persistencia");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Resultado resultado = em.find(Resultado.class, this.id);
            em.remove(resultado);
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

    public static Resultado buscarPorId(long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistema AvaliacaoPU");
        EntityManager em = emf.createEntityManager();

        Resultado resultado = em.find(Resultado.class, id);

        em.close();
        emf.close();

        return resultado;
    }
}

