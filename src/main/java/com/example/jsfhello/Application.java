package com.example.jsfhello;

import com.example.jsfhello.config.Config;
import jakarta.persistence.EntityManager;

public class Application {
    public static void main(String[] args) {
        EntityManager em = Config.getConfig().getEntityManager();
        try {
            User user = new User();
            user.setFirstname("idriss");
            user.setId(1);
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

}
