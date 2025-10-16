package org.ahmsa.bookshelf.service;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.ahmsa.bookshelf.data.Genre;
import org.ahmsa.bookshelf.data.GenreDto;
import org.ahmsa.bookshelf.repository.GenreRepository;

import java.util.List;

@ApplicationScoped
public class GenreService {
    @Inject
    GenreRepository genreRepository;

    public List<GenreDto> getAllGenres() {
        List<Genre> allGenres = genreRepository.findAll();
        if(allGenres == null || allGenres.isEmpty()){
            return List.of();
        }
        return allGenres.stream().map(GenreDto::new).toList();
    }

    public GenreDto saveGenre(GenreDto genre) {
        Genre savedGenre = genreRepository.save(genre.getEntity());
        return new GenreDto(savedGenre);
    }
}
