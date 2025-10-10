package org.ahmsa.bookshelf.service;

import jakarta.inject.Inject;
import org.ahmsa.bookshelf.data.Book;
import org.ahmsa.bookshelf.repository.BookRepository;

import java.util.List;

public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getByTitle(String title) {
        bookRepository.findByTitle(title);
    }
}
