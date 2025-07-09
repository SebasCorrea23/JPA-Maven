package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.modelo.Persona;
import java.util.List;
import org.example.util.JPAUtil;

// Esta clase contiene métodos para guardar o buscar personas
public class PersonaDAO {

    public void guardarPersona(Persona persona) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();    // Inicia la transacción
            em.persist(persona);           // Guarda el objeto en la BD
            em.getTransaction().commit();  // Finaliza la transacción
        } catch (Exception e) {
            em.getTransaction().rollback(); // Revierte si hay error
            e.printStackTrace();
        } finally {
            em.close(); // Siempre cerrar
        }
    }

    public List<Persona> obtenerTodas() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Persona> personas = null;
        try {
            personas = em.createQuery("SELECT p FROM Persona p", Persona.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return personas;
    }

}
