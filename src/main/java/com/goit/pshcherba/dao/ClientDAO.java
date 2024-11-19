package com.goit.pshcherba.dao;

import com.goit.pshcherba.domain.Client;
import com.goit.pshcherba.domain.Planet;
import org.hibernate.SessionFactory;

/**
 * The ClientDAO class provides data access operations specific to the
 * {@link Client} entity.
 * It extends the {@link GenericDAO} class and provides client-specific functionality
 * for interacting with the database.
 * <p>
 * The class leverages the {@link SessionFactory} to create sessions and execute
 * database operations.
 * related to the {@link Client} entity.
 */
public class ClientDAO extends GenericDAO<Client> {

    /**
     * Constructor for creating a ClientDAO instance.
     *
     * @param sessionFactory the Hibernate {@link SessionFactory} to be used
     * for session management.
     */
    public ClientDAO(SessionFactory sessionFactory) {
        super(Client.class, sessionFactory);
    }
}
