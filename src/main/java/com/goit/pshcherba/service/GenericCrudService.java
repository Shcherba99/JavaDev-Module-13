package com.goit.pshcherba.service;

import com.goit.pshcherba.dao.GenericDAO;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * The {@link GenericCrudService} class provides common CRUD operations for
 * entities of type {@link T}.
 * This class acts as a service layer, abstracting the data access logic from
 * the rest of the application.
 * It is designed to work with any entity type, provided that a corresponding
 * {@link GenericDAO} is available.
 * <p>
 * The operations include methods to:
 * - Find an entity by its ID
 * - Get a list of items with pagination
 * - Find all entities
 * - Save, update, and delete entities
 *
 * @param <T> the type of entity managed by this service
 * @see com.goit.pshcherba.dao.GenericDAO
 */
@RequiredArgsConstructor
public class GenericCrudService<T> {
    private final GenericDAO<T> dao;

    /**
     * Finds an entity by its ID.
     *
     * @param id the ID of the entity to find
     * @return the entity with the given ID or {@code null} if not found
     */
    public T findById(Object id) {
        return dao.findById(id);
    }

    /**
     * Retrieves a list of entities with pagination.
     *
     * @param offset the position in the list to start retrieving from
     * @param count  the maximum number of entities to retrieve
     * @return a list of entities starting from the specified offset
     */
    public List<T> getItems(int offset, int count) {
        return dao.getItems(offset, count);
    }

    /**
     * Retrieves all entities.
     *
     * @return a list of all entities
     */
    public List<T> findlAll() {
        return dao.findAll();
    }

    /**
     * Saves a new entity.
     *
     * @param entity the entity to save
     * @return the saved entity
     */
    public T save(T entity) {
        return dao.save(entity);
    }

    /**
     * Updates an existing entity.
     *
     * @param entity the entity to update
     * @return the updated entity
     */
    public T update(T entity) {
        return dao.update(entity);
    }

    /**
     * Deletes the specified entity.
     *
     * @param entity the entity to delete
     */
    public void delete(T entity) {
        dao.delete(entity);
    }
}
