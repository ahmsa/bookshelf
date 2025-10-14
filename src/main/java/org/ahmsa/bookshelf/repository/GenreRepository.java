package org.ahmsa.bookshelf.repository;

import org.ahmsa.bookshelf.data.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, String> {
}
