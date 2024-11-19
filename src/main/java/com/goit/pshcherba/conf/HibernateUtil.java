package com.goit.pshcherba.conf;

import com.goit.pshcherba.domain.Planet;
import com.goit.pshcherba.domain.Client;
import com.goit.pshcherba.domain.Ticket;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * HibernateUtil is a utility class responsible for providing a singleton instance of
 * the Hibernate SessionFactory.
 * It is used to manage Hibernate sessions for interacting with the database.
 * <p>
 * This class ensures that there is a single instance of the SessionFactory throughout
 * the application,
 * and provides methods to retrieve and close the SessionFactory.
 */
public class HibernateUtil {

    // Singleton instance of HibernateUtil
    private static HibernateUtil instance;

    // Hibernate SessionFactory to interact with the database
    private final SessionFactory sessionFactory;

    /**
     * Private constructor to initialize the Hibernate SessionFactory.
     * It configures Hibernate with the necessary annotated classes for the domain
     * model (Client and Planet).
     */
    private HibernateUtil() {
        this.sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();
    }

    /**
     * Provides access to the singleton instance of SessionFactory.
     * If the instance is null or the SessionFactory is closed,
     * a new instance is created.
     */
    public static SessionFactory getSessionFactory() {
        if (instance == null || instance.sessionFactory.isClosed()) {
            instance = new HibernateUtil();
        }

        return instance.sessionFactory;
    }


    public void closeSessionFactory() {
        if (instance != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }
}
