package com.goit.pshcherba.dao;

import com.goit.pshcherba.domain.Ticket;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

/**
 * The TicketDAO class provides data access operations specific to the
 * {@link Ticket} entity.
 * It extends the {@link GenericDAO} class and provides client-specific functionality
 * for interacting with the database.
 * <p>
 * The class leverages the {@link SessionFactory} to create sessions and execute
 * database operations related to the {@link Ticket} entity.
 */
public class TicketDAO extends GenericDAO<Ticket> {

    /**
     * Constructor for creating a TicketDAO instance.
     *
     * @param sessionFactory the Hibernate {@link SessionFactory} to be used
     * for session management.
     */
    public TicketDAO(SessionFactory sessionFactory) {
        super(Ticket.class, sessionFactory);
    }

    /**
     * Retrieves all tickets with their associated client, from planet, and to planet.
     * Uses a single query to avoid the N+1 problem by fetching related entities eagerly.
     *
     * @return a list of all tickets with their associated entities.
     * @throws RuntimeException if there is an error during the retrieval.
     */
    public List<Ticket> findAll() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "SELECT t FROM Ticket t " +
                    "JOIN FETCH t.client " +
                    "JOIN FETCH t.fromPlanet " +
                    "JOIN FETCH t.toPlanet";
            Query<Ticket> query = session.createQuery(hql, Ticket.class);
            return query.getResultList();
        } catch (HibernateException e) {
            throw new RuntimeException("Error finding all tickets", e);
        }
    }

    /**
     * Retrieves a paginated list of tickets with their associated client, from planet, and to planet.
     * Uses a single query to avoid the N+1 problem by fetching related entities eagerly.
     *
     * @param offset the starting point of the query.
     * @param count  the number of tickets to retrieve.
     * @return a list of tickets with their associated entities.
     * @throws RuntimeException if there is an error during the retrieval.
     */
    public List<Ticket> getItems(int offset, int count) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "SELECT t FROM Ticket t " +
                    "JOIN FETCH t.client " +
                    "JOIN FETCH t.fromPlanet " +
                    "JOIN FETCH t.toPlanet";
            Query<Ticket> query = session.createQuery(hql, Ticket.class);
            query.setFirstResult(offset);
            query.setMaxResults(count);
            return query.getResultList();
        } catch (HibernateException e) {
            throw new RuntimeException("Error getting tickets with offset: " + offset + " and count: " + count, e);
        }
    }
}
