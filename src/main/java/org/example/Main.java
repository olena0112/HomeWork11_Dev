package org.example;
import org.example.entities.Client;
import org.example.entities.Planet;
import org.example.entities.Ticket;
import org.example.services.ClientCrudService;
import org.example.services.PlanetCrudService;
import org.example.services.TicketCrudService;
import org.example.storage.DataBaseInitPopulateService;
import org.example.storage.Database;
import org.hibernate.SessionFactory;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        Database database=Database.getInstance();
        new DataBaseInitPopulateService().initDb(database);
       SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        ClientCrudService clientCrudService = new ClientCrudService(sessionFactory);
        PlanetCrudService planetCrudService = new PlanetCrudService(sessionFactory);
        TicketCrudService ticketService = new TicketCrudService(sessionFactory, clientCrudService, planetCrudService);

        Client newClient = new Client("John Doe");
        clientCrudService.createClient(newClient);
        System.out.println("Доданий клієнт: " + newClient);

   /*     newClient.setName("Jane Smith");
        clientCrudService.updateClient(newClient);
        System.out.println("Оновлений клієнт: " + newClient);

        long clientId = newClient.getId();
        Client retrievedClient = clientCrudService.readClient(clientId);
        System.out.println("Зчитаний клієнт: " + retrievedClient);

        clientCrudService.deleteClient(clientId);
        System.out.println("Клієнт був видалений.");

*/
        Planet newPlanet = new Planet("MERK" , "Merkury");
        planetCrudService.createPlanet(newPlanet);
        System.out.println("Додана планета: " + newPlanet);

    /*   newPlanet.setName("New Earth");
        planetCrudService.updatePlanet(newPlanet);
        System.out.println("Оновлена планета: " + newPlanet);

        String planetId = newPlanet.getId();
        Planet retrievedPlanet = planetCrudService.readPlanet(planetId);
        System.out.println("Зчитана планета: " + retrievedPlanet);

        planetCrudService.deletePlanet(planetId);
        System.out.println("Планета була видалена.");


*/
   Ticket newTicket = new Ticket();
     Date currentDate = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
     newTicket.setCreatedAt(currentDate);
     newTicket.setClient(newClient);
     newTicket.setFromPlanet(new Planet("VEN","VENUS"));
     newTicket.setToPlanet(newPlanet);
     ticketService.addTicket(newTicket);

     long ticketId = newTicket.getId();
     Ticket retrievedTicket = ticketService.getTicketById(ticketId);
     System.out.println("Зчитаний квиток: " + retrievedTicket);

        Planet newPlanet1 = new Planet("NEW_PLANET_ID", "NEW_PLANET");
        planetCrudService.createPlanet(newPlanet1);

        Planet newFromPlanet = planetCrudService.readPlanet("NEW_PLANET_ID");
        retrievedTicket.setFromPlanet(newFromPlanet);
        ticketService.updateTicket(retrievedTicket);


   /* ticketService.deleteTicket(ticketId);
     System.out.println("Квиток був видалений.");

*/
        sessionFactory.close();

    }
}