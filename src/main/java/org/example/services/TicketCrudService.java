package org.example.services;

import org.example.entities.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;

public class TicketCrudService {
    private ClientCrudService clientCrudService;
   private PlanetCrudService planetCrudService;
    private final SessionFactory sessionFactory;

    public TicketCrudService(SessionFactory sessionFactory, ClientCrudService clientCrudService, PlanetCrudService planetCrudService) {
        this.sessionFactory = sessionFactory;
        this.clientCrudService = clientCrudService;
        this.planetCrudService = planetCrudService;
    }

    public void addTicket(Ticket ticket) {
        if (ticket.getClient() == null || clientCrudService.readClient(ticket.getClient().getId()) == null) {
            throw new IllegalArgumentException("?????? ?? ????????? ??? ?? ????????.");
        }

        if (ticket.getFromPlanet() == null || planetCrudService.readPlanet(ticket.getFromPlanet().getId()) == null) {
            throw new IllegalArgumentException("????????? ??????? ?? ???????? ??? ?? ???????.");
        }

        if (ticket.getToPlanet() == null || planetCrudService.readPlanet(ticket.getToPlanet().getId()) == null) {
            throw new IllegalArgumentException("??????? ??????? ?? ???????? ??? ?? ???????.");
        }

        ticket.setCreatedAt(new Date());

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(ticket);
            transaction.commit();
        }
    }

    public Ticket getTicketById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Ticket.class, id);
        }
    }

    public void updateTicket(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(ticket);
            transaction.commit();
        }
    }

    public void deleteTicket(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Ticket ticket = session.get(Ticket.class, id);
            if (ticket != null) {
                session.delete(ticket);
            }
            transaction.commit();
        }
    }


}
