package com.goit.pshcherba.service;

import com.goit.pshcherba.conf.HibernateUtil;
import com.goit.pshcherba.dao.ClientDAO;
import com.goit.pshcherba.domain.Client;


/**
 * The {@link ClientCrudService} class provides CRUD (Create, Read, Update, Delete)
 * operations for the {@link Client} entity. It extends the {@link GenericCrudService}
 * class and is specifically designed to work with {@link Client} objects.
 * <p>
 * This service class interacts with the {@link ClientDAO} to perform database
 * operations and uses Hibernate for persistence.
 * <p>
 * The constructor initializes the service with a {@link ClientDAO}, which is
 * responsible
 * for managing the persistence of {@link Client} entities.
 *
 * @see com.goit.pshcherba.dao.ClientDAO
 * @see com.goit.pshcherba.domain.Client
 * @see com.goit.pshcherba.conf.HibernateUtil
 * @see GenericCrudService
 */
public class ClientCrudService extends GenericCrudService<Client> {

    /**
     * Constructs a new {@link ClientCrudService} instance.
     * This constructor initializes the service with a {@link ClientDAO},
     * which is responsible for managing the persistence of {@link Client}
     * entities using Hibernate.
     * The {@link ClientDAO} is instantiated with the session factory provided
     * by {@link HibernateUtil}.
     */
    public ClientCrudService() {
        super(new ClientDAO(HibernateUtil.getSessionFactory()));
    }
}
