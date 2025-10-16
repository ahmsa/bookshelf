package org.ahmsa.bookshelf.repository;

import org.ahmsa.bookshelf.data.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, String> {
    public List<Author> findAll();
    public List<Author> findByName(String name);
}
