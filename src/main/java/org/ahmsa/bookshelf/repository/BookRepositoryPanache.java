package org.ahmsa.bookshelf.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.ahmsa.bookshelf.data.Book;

import java.util.List;

@ApplicationScoped
public class BookRepositoryPanache implements PanacheRepository<Book> {
    public List<Book> findByTitle(String alexRider) {
        return list("title", alexRider);
    }
}
