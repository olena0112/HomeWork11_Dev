package org.example.entities;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Data
@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "from_planet_id")
    private Planet fromPlanet;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "to_planet_id")
    private Planet toPlanet;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", client=" + client +
                ", fromPlanet=" + fromPlanet +
                ", toPlanet=" + toPlanet +
                ", createdAt=" + createdAt +
                '}';
    }
}



