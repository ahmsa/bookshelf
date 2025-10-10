package org.ahmsa.bookshelf.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.ahmsa.bookshelf.data.Book;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository extends BaseRepository implements PanacheRepository<Book> {
    public List<Book> findByTitle(String title) {
        return find("title", title).list();
    }
}
