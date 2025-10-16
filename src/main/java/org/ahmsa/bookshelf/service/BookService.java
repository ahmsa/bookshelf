package org.ahmsa.bookshelf.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.ahmsa.bookshelf.data.Book;
import org.ahmsa.bookshelf.data.BookBaseDto;
import org.ahmsa.bookshelf.data.BookDto;
import org.ahmsa.bookshelf.repository.BookRepository;

import java.util.List;

@ApplicationScoped
public class BookService {
    @Inject
    BookRepository bookRepository;

    public List<BookDto> getByTitle(String title) {
        List<Book> byTitle = bookRepository.findByTitle(title);
        if(byTitle == null || byTitle.isEmpty()){
            return List.of();
        }
        return byTitle.stream().map(BookDto::new).toList();
    }

    public List<BookDto> getAllBooks() {
        List<Book> all = bookRepository.findAll();

        if(all == null || all.isEmpty()){
            return List.of();
        }

        return all.stream().map(BookDto::new).toList();
    }

    public BookDto saveBook(BookBaseDto book) {
        Book savedBook = bookRepository.save(book.getEntity());
        return new BookDto(savedBook);
    }
}
