package org.ahmsa.bookshelf.repository;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.ahmsa.bookshelf.data.Book;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class BookRepositoryTest {

    @Inject
    BookRepository bookRepository;

    @BeforeEach
    @Transactional
    void setUp() {
        // Clean up the repository before each test
        bookRepository.deleteAll();
    }

    @Test
    @Transactional
    void findByTitle() {
        Book book = new Book();
        book.setTitle("Book 1");

        bookRepository.persist(book);
        List<Book> byTitle = bookRepository.findByTitle("Book 1");
        assertNotNull(byTitle);
        assertEquals(1, byTitle.size());
        assertEquals("Book 1", byTitle.get(0).getTitle());
    }
}