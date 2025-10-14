package org.ahmsa.bookshelf.repository;

import org.ahmsa.bookshelf.data.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, String> {
}
