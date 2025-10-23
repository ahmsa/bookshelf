package org.ahmsa.bookshelf.repository;

import jakarta.enterprise.context.ApplicationScoped;
import org.ahmsa.bookshelf.data.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@ApplicationScoped
@Repository
public interface  BookRepository extends CrudRepository<Book, Long> {
    public List<Book> findByTitle(String title);
    public List<Book> findAll();
}
