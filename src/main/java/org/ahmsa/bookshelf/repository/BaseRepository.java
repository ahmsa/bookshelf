package org.ahmsa.bookshelf.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.ahmsa.bookshelf.data.IEntity;

@ApplicationScoped
public class BaseRepository {
    @Inject
    protected EntityManager entityManager;

    public <T extends IEntity> T getById(Class<T> clazz, String id) {
        return entityManager.find(clazz, id);
    }

    public <T extends IEntity> T save(T entity) {
        return entityManager.merge(entity);
    }

    public <T extends IEntity> void delete(T entity) {
        entityManager.remove(entity);
    }

    public <T extends IEntity> void deleteById(Class<T> clazz, String id) {
        T entity = getById(clazz, id);
        if (entity != null) {
            delete(entity);
        }
    }

    public <T extends IEntity> T findByName(Class<T> clazz, String name) {
        String query = "SELECT e FROM " + clazz.getSimpleName() + " e WHERE e.name = :name";
        return entityManager.createQuery(query, clazz)
                .setParameter("name", name)
                .getSingleResult();
    }
}
