package br.com.webdinam.sistemaAvaliacao.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

        private static final String PERSISTENCE_UNIT_NAME = "sistemaAvaliacaoPU";
        private static final EntityManagerFactory emf;

        static {
            try {
                emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            } catch (Throwable ex) {
                System.err.println("Falha ao criar EntityManagerFactory." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }

        public static EntityManager getEntityManager() {
            return emf.createEntityManager();
        }

        public static void closeEntityManager(EntityManager em) {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }
