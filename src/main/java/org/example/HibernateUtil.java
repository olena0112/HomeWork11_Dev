package org.example;
import lombok.Getter;
import org.example.entities.Client;
import org.example.entities.Planet;
import org.example.entities.Ticket;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {

            Configuration configuration = new Configuration()
                    .setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect")
                    .setProperty("hibernate.connection.driver_class", "org.h2.Driver")
                    .setProperty("hibernate.connection.url", "jdbc:h2:./database1;TRACE_LEVEL_SYSTEM_OUT=3")
                    .setProperty("hibernate.connection.pool_size", "10")
                    .setProperty("hibernate.connection.autocommit", "true");

            configuration.addAnnotatedClass(Client.class);
            configuration.addAnnotatedClass(Planet.class);
            configuration.addAnnotatedClass(Ticket.class);

            return configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}


