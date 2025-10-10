package org.ahmsa.bookshelf.service;

import jakarta.inject.Inject;
import org.ahmsa.bookshelf.data.Book;
import org.ahmsa.bookshelf.repository.BookRepository;

import java.util.List;

public class BookService {
    @Inject
    private BookRepository bookRepository;

    public List<Book> getByTitle(String title) {
        return bookRepository.findByTitle(title);
    }
}
