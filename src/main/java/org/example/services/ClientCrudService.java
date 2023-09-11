package org.example.services;
import org.example.entities.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ClientCrudService {
    private final SessionFactory sessionFactory;

    public ClientCrudService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createClient(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(client);
            transaction.commit();
        }
    }

    public void updateClient(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(client);
            transaction.commit();
        }
    }

    public Client readClient(Long clientId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Client.class, clientId);
        }
    }

    public void deleteClient(Long clientId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Client client = session.get(Client.class, clientId);
            if (client != null) {
                session.delete(client);
            }
            transaction.commit();
        }
    }
}

