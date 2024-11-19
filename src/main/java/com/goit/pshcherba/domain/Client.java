package com.goit.pshcherba.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


/**
 * The {@link Client} class represents an entity in the "space_travel" schema
 * with the table name "client".
 * This entity class is mapped to a database table and is used to persist client data.
 * <p>
 * It contains fields like {@code id} (primary key) and {@code name} (name of the
 * client).
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
@Table(schema = "space_travel", name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 200, nullable = false)
    private String name;

    @ToString.Exclude
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private List<Ticket> tickets;
}
