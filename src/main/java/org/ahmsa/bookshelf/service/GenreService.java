package org.ahmsa.bookshelf.service;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.ahmsa.bookshelf.data.Genre;
import org.ahmsa.bookshelf.data.GenreDto;
import org.ahmsa.bookshelf.repository.GenreRepository;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class GenreService implements IService<Genre, GenreDto> {
    @Inject
    GenreRepository genreRepository;

    @Override
    public GenreRepository getCrudRepository() {
        return this.genreRepository;
    }

    @Override
    public GenreDto getDtoInstance() {
        return new  GenreDto();
    }
}
