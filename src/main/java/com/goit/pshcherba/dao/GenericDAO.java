package com.goit.pshcherba.dao;

import lombok.RequiredArgsConstructor;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * GenericDAO is an abstract class that provides basic CRUD operations for
 * any entity type {@link T}.
 * It uses Hibernate ORM to interact with the database and provides methods
 * to find, save, update, and delete entities.
 * <p>
 * The class is parameterized with a generic type {@link T}, which represents
 * the type of the entity the DAO is working with.
 * The entity class is passed in the constructor along with the Hibernate
 * {@link SessionFactory}.
 */
@RequiredArgsConstructor
public abstract class GenericDAO<T> {
    private final Class<T> clazz;
    protected final SessionFactory sessionFactory;

    /**
     * Finds an entity by its ID.
     *
     * @param id the ID of the entity to find.
     * @return the entity with the given ID, or {@code null} if not found.
     * @throws RuntimeException if there is an error during the find operation.
     */
    public T findById(Object id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(clazz, id);
        } catch (HibernateException e) {
            throw new RuntimeException("Error find by id: " + id);
        }
    }

    /**
     * Retrieves a list of entities, with pagination.
     *
     * @param offset the starting point of the query.
     * @param count the number of entities to retrieve.
     * @return a list of entities.
     * @throws RuntimeException if there is an error during the retrieval.
     */
    public List<T> getItems(int offset, int count) {
        try (Session session = sessionFactory.openSession()) {
            Query<T> query = session.createQuery("from "
                    + clazz.getName(), clazz);
            query.setFirstResult(offset);
            query.setMaxResults(count);
            return query.getResultList();
        } catch (HibernateException e) {
            throw new RuntimeException("Error get items " + "offset: "
                    + offset + ", count: " + count);
        }
    }

    /**
     * Retrieves all entities of the given type.
     *
     * @return a list of all entities.
     * @throws RuntimeException if there is an error during the retrieval.
     */
    public List<T> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from "
                    + clazz.getName(), clazz).list();
        } catch (HibernateException e) {
            throw new RuntimeException("Error find all");
        }
    }

    /**
     * Saves a new entity in the database.
     *
     * @param entity the entity to save.
     * @return the saved entity.
     * @throws RuntimeException if there is an error during the save operation.
     */
    public T save(T entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
            return entity;
        } catch (HibernateException e) {
            throw new RuntimeException("Error saving " + entity, e);
        }
    }

    /**
     * Updates an existing entity in the database.
     *
     * @param entity the entity to update.
     * @return the updated entity.
     * @throws RuntimeException if there is an error during the update operation.
     */
    public T update(T entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            T mergeEntity = session.merge(entity);
            transaction.commit();
            return mergeEntity;
        } catch (HibernateException e) {
            throw new RuntimeException("Error updating " + entity, e);
        }
    }

    /**
     * Deletes an entity from the database.
     *
     * @param entity the entity to delete.
     * @throws RuntimeException if there is an error during the delete operation.
     */
    public void delete(T entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(entity);
            transaction.commit();
        } catch (HibernateException e) {
            throw new RuntimeException("Error deleting " + entity, e);
        }
    }
}
