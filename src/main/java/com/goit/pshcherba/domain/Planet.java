package com.goit.pshcherba.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * The {@link Planet} class represents an entity in the "space_travel" schema
 * with the table name "planet".
 * This entity class is mapped to a database table and is used to persist planet data.
 * <p>
 * It contains fields like {@code id} (primary key) and {@code name} (name of the
 * planet).
 * The class uses Lombok annotations for boilerplate code generation
 * (getters, setters, constructors, etc.).
 *
 * @see lombok.Data
 * @see lombok.AllArgsConstructor
 * @see lombok.NoArgsConstructor
 * @see lombok.Builder
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(schema = "space_travel", name = "planet")
public class Planet {

    @Id
    @Column(length = 50, nullable = false)
    private String id;

    @Column(length = 50, nullable = false)
    private String name;

    @ToString.Exclude
    @OneToMany(mappedBy = "fromPlanet", fetch = FetchType.LAZY)
    private List<Ticket> departureTickets;

    @ToString.Exclude
    @OneToMany(mappedBy = "toPlanet", fetch = FetchType.LAZY)
    private List<Ticket> arrivalTickets;
}
