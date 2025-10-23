package org.ahmsa.bookshelf.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.ahmsa.bookshelf.data.Book;
import org.ahmsa.bookshelf.data.BookBaseDto;
import org.ahmsa.bookshelf.data.BookDto;
import org.ahmsa.bookshelf.repository.BookRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@ApplicationScoped
public class BookService implements IService<Book, BookDto> {
    @Inject
    BookRepository bookRepository;

    @Override
    public CrudRepository<Book, Long> getCrudRepository() {
        return this.bookRepository;
    }

    @Override
    public BookDto getDtoInstance() {
        return new BookDto();
    }

    public List<BookDto> getByTitle(String title) {
        List<Book> byTitle = bookRepository.findByTitle(title);
        if(byTitle == null || byTitle.isEmpty()){
            return List.of();
        }
        return byTitle.stream().map(BookDto::new).toList();
    }
}
