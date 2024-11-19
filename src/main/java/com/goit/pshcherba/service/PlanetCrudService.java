package com.goit.pshcherba.service;

import com.goit.pshcherba.conf.HibernateUtil;
import com.goit.pshcherba.dao.PlanetDAO;
import com.goit.pshcherba.domain.Planet;


/**
 * The {@link PlanetCrudService} class provides CRUD (Create, Read, Update, Delete)
 * operations for the {@link Planet} entity. It extends the {@link GenericCrudService}
 * class and is specifically designed to work with {@link Planet} objects.
 * <p>
 * This service class interacts with the {@link PlanetDAO} to perform database
 * operations and uses Hibernate for persistence.
 * <p>
 * The constructor initializes the service with a {@link PlanetDAO},
 * which is responsible
 * for managing the persistence of {@link Planet} entities.
 *
 * @see com.goit.pshcherba.dao.PlanetDAO
 * @see com.goit.pshcherba.domain.Planet
 * @see com.goit.pshcherba.conf.HibernateUtil
 * @see GenericCrudService
 */
public class PlanetCrudService extends GenericCrudService<Planet> {

    /**
     * Constructs a new {@link PlanetCrudService} instance.
     * This constructor initializes the service with a {@link PlanetDAO},
     * which is responsible for managing the persistence of {@link Planet}
     * entities using Hibernate.
     * The {@link PlanetDAO} is instantiated with the session factory provided
     * by {@link HibernateUtil}.
     */
    public PlanetCrudService() {
        super(new PlanetDAO(HibernateUtil.getSessionFactory()));
    }
}
