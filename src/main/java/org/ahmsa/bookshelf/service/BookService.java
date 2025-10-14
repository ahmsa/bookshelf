package org.ahmsa.bookshelf.service;

import jakarta.inject.Inject;
import org.ahmsa.bookshelf.data.Book;
import org.ahmsa.bookshelf.data.BookDto;
import org.ahmsa.bookshelf.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<BookDto> getByTitle(String title) {
        List<Book> byTitle = bookRepository.findByTitle(title);
        return byTitle.stream().map(BookDto::new).toList();
    }
}
