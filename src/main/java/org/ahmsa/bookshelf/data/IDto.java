package org.ahmsa.bookshelf.data;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public interface IDto<E extends IEntity> {
    @JsonIgnore
    void populateFromEntity(E entity);

    @JsonIgnore
    public default List<IDto<E>> populateFromEntites(Iterable<E> entities){
        return ((List<E>) entities).stream().map(entity -> {
            try {
                IDto<E> dto = this.getClass().getDeclaredConstructor().newInstance();
                dto.populateFromEntity(entity);
                return dto;
            } catch (Exception ex) {
                throw new RuntimeException("Failed to create DTO instance", ex);
            }
        }).toList();
    }

    @JsonIgnore
    public E getEntity();

    @JsonIgnore
    public E updateEntity(E entity);
}
