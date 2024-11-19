package com.goit.pshcherba.dao;

import com.goit.pshcherba.domain.Client;
import com.goit.pshcherba.domain.Planet;
import org.hibernate.SessionFactory;

/**
 * The PlanetDAO class provides data access operations specific to the
 * {@link Planet} entity.
 * It extends the {@link GenericDAO} class and provides client-specific functionality
 * for interacting with the database.
 * <p>
 * The class leverages the {@link SessionFactory} to create sessions and execute
 * database operations.
 * related to the {@link Planet} entity.
 */
public class PlanetDAO extends GenericDAO<Planet> {

    /**
     * Constructor for creating a PlanetDAO instance.
     *
     * @param sessionFactory the Hibernate {@link SessionFactory} to be used
     * for session management.
     */
    public PlanetDAO(SessionFactory sessionFactory) {
        super(Planet.class, sessionFactory);
    }
}
