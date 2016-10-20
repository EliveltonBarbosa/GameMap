/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.elivelton.persistenceSingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Elivelton
 */
public class PersistenceUtil {
    private static final String PERSISTENCE_UNIT_NAME = "GameMapPU";
    private static EntityManagerFactory entityManagerFactory = null;
    private static EntityManager entityManager = null;

    private PersistenceUtil() {
    }

    static {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static EntityManager getEntityManager() {
        try {
            if (entityManager == null || !entityManager.isOpen()) {
                entityManager = entityManagerFactory.createEntityManager();
            }
            return entityManager;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void closeEntityManager() {
        try {
            if (entityManager != null) {
                EntityTransaction transaction = entityManager.getTransaction();
                if (transaction.isActive()) {
                    transaction.commit();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

    }

    public static void closeEntityManagerFactory() {
        closeEntityManager();
        entityManagerFactory.close();
    }
}
