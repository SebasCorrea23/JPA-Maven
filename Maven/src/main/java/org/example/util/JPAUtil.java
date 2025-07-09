package org.example.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

// Esta clase se encarga de crear el EntityManager (conexión a la BD)
public class JPAUtil {

    // Nombre debe coincidir con <persistence-unit name="..."> del persistence.xml
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("PersonaJPA");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
