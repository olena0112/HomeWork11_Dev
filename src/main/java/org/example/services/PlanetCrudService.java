package org.example.services;
import org.example.entities.Planet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PlanetCrudService {
    private final SessionFactory sessionFactory;

    public PlanetCrudService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createPlanet(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(planet);
            transaction.commit();
        }
    }

    public void updatePlanet(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(planet);
            transaction.commit();
        }
    }

    public Planet readPlanet(String planetId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Planet.class, planetId);
        }
    }

    public void deletePlanet(String planetId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Planet planet = session.get(Planet.class, planetId);
            if (planet != null) {
                session.delete(planet);
            }
            transaction.commit();
        }
    }
}
