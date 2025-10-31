package org.ahmsa.bookshelf.service;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.ahmsa.bookshelf.data.Genre;
import org.ahmsa.bookshelf.data.GenreDto;
import org.ahmsa.bookshelf.repository.GenreRepository;

import java.util.List;

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

    @Override
    public void delete(Long id) {
        this.disassociateChildGenres(id);
        IService.super.delete(id);
    }

    private void disassociateChildGenres(Long id) {
        List<Genre> childGenres = genreRepository.findByParentGenreId(id);
        for (Genre childGenre : childGenres) {
            disassociateChildGenres(childGenre.getId());
            genreRepository.deleteById(childGenre.getId());
        }
    }
}
