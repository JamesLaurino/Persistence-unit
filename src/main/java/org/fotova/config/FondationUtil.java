package org.fotova.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FondationUtil
{
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("persistenceUnit");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void close() {
        emf.close();
    }
}
