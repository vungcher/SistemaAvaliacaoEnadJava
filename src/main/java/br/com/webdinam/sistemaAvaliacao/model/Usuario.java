package br.com.webdinam.sistemaAvaliacao.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    private String nome;
    private String email;
    private String senha;

    @ManyToOne
    @JoinColumn(name = "tipousuario_idtipousuario")
    private TipoUsuario tipoUsuario;



    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
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

    
    public void excluir() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistemaAvaliacaoPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Usuario usuario = em.find(Usuario.class, this.idUsuario);
            em.remove(usuario);
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

    
    public static Usuario buscarPorId(int idUsuario) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistemaAvaliacaoPU");
        EntityManager em = emf.createEntityManager();

        Usuario usuario = em.find(Usuario.class, idUsuario);

        em.close();
        emf.close();

        return usuario;
    }

    
    public static List<Usuario> listarTodos() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistemaAvaliacaoPU");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u", Usuario.class);
        List<Usuario> usuarios = query.getResultList();

        em.close();
        emf.close();

        return usuarios;
    }

}

