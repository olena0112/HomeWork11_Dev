package org.example.storage;

import org.flywaydb.core.Flyway;

public class DataBaseInitPopulateService {
    public void initDb(Database database){
        String jdbcUrl = "jdbc:h2:./database1";
        String jdbcUser = "";
        Flyway flyway = Flyway.configure().dataSource(jdbcUrl, jdbcUser, null).load();
        flyway.migrate();
        System.out.println("Flyway migration completed.");
    }
}
