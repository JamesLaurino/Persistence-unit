package org.fotova.dao;

import org.fotova.config.FondationUtil;
import org.fotova.entity.Customer;

import jakarta.persistence.EntityManager;


public class JpaUtil
{
    public void insertEntity(Customer entity)
    {
        EntityManager em = FondationUtil.getEntityManager();
        try {

            em.getTransaction().begin();
            em.persist(entity);
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

    public Customer getEntity(Long id)
    {
        EntityManager em = FondationUtil.getEntityManager();

        try {
            return em.find(Customer.class, id);
        } finally {
            em.close();
        }
    }

    public void deleteEntity(Long id)
    {
        EntityManager em = FondationUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Customer entity = em.find(Customer.class, id);
            if (entity != null) {
                em.remove(entity);
            }
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
}
