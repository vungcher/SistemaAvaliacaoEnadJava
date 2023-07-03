

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteConexaoBD {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("sistemaAvaliacaoPU");
            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        } finally {
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }
//    public static void main(String[] args) {
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sistemaAvaliacaoPU");
//        entityManagerFactory.close();
//    }
}
