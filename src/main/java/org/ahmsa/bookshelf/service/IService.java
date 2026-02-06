package org.ahmsa.bookshelf.service;

import java.util.List;

import org.ahmsa.bookshelf.data.IDto;
import org.ahmsa.bookshelf.data.IEntity;
import org.springframework.data.repository.CrudRepository;

public interface IService<E extends IEntity, D extends IDto<E>> {
    CrudRepository<E, Long> getCrudRepository();

    public D getDtoInstance();

    public default List<D> getAll() {
        Iterable<E> allItr = getCrudRepository().findAll();

        return (List<D>) getDtoInstance().populateFromEntites(allItr);
    }

    public default void delete(Long id) {
        getCrudRepository().deleteById(id);
    }

    public default void delete(D dto) {
        E entity = dto.getEntity();
        getCrudRepository().delete(entity);
    }

    public default D save(D dto) {
        if (dto == null) {
            throw new IllegalArgumentException("DTO cannot be null");
        }

        if (dto.getEntity().getId() != null) {
            return this.update(dto);
        }

        E entity = dto.getEntity();
        E savedEntity = getCrudRepository().save(entity);
        dto.populateFromEntity(savedEntity);
        return dto;
    }

    public default D update(D dto) {
        E entity = dto.getEntity();
        E existingEntity = getCrudRepository().findById(entity.getId()).orElseThrow(() -> new RuntimeException("Entity not found"));
        existingEntity = dto.updateEntity(existingEntity);
        getCrudRepository().save(existingEntity);
        existingEntity = getCrudRepository().findById(entity.getId()).orElseThrow(() -> new RuntimeException("Entity not found"));
        dto.populateFromEntity(existingEntity);
        return dto;
    }

    public default D getById(Long id) {
        E entity = getCrudRepository().findById(id).orElseThrow(() -> new RuntimeException("Entity not found"));
        D dto = getDtoInstance();
        dto.populateFromEntity(entity);
        return dto;
    }
}
