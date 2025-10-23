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

    @Inject
    BookRepositoryPanache bookRepositoryPanache;

    @BeforeEach
    @Transactional
    void setUp() {
        // Clean up the repository before each test
        bookRepository.deleteAll();

        bookRepositoryPanache.deleteAll();
    }

    @Test
    @Transactional
    void findByTitle() {
        Book book = new Book();
        book.setTitle("Alex Rider");

        bookRepository.save(book);
        List<Book> byTitle = bookRepository.findByTitle("Alex Rider");
        assertNotNull(byTitle);
        assertEquals(1, byTitle.size());
        assertEquals("Alex Rider", byTitle.getFirst().getTitle());
    }

    @Test
    @Transactional
    void findByTitlePanache() {
        Book book = new Book();
        book.setTitle("Alex Rider");

        bookRepositoryPanache.persist(book);
        List<Book> byTitle = bookRepositoryPanache.findByTitle("Alex Rider");
        assertNotNull(byTitle);
        assertEquals(1, byTitle.size());
        assertEquals("Alex Rider", byTitle.getFirst().getTitle());
    }

    @Test
    @Transactional
    void findByTitleTimings() {
        int iterations = 1000;
        long startTime, endTime;

        startTime = System.currentTimeMillis();

        System.out.println("Testing BookRepository (Spring Data JPA) with " + iterations + " iterations:");
        System.out.println("Starting Time: " + startTime);
        for (int i = 0; i < iterations; i++) {
            String title = "Alex Rider " + i;
            Book book = new Book();
            book.setTitle(title);

            bookRepository.save(book);
            List<Book> byTitle = bookRepository.findByTitle(title);
            assertNotNull(byTitle);
            assertEquals(1, byTitle.size());
            assertEquals(title, byTitle.getFirst().getTitle());
        }
        endTime = System.currentTimeMillis();
        System.out.println("Ending Time: " + endTime);
        long duration = endTime - startTime;
        System.out.println("Total Time taken for " + iterations + " iterations: " + duration);
    }

    @Test
    @Transactional
    void findByTitlePanacheTimings() {
        int iterations = 1000;
        long startTime, endTime;
        startTime = System.currentTimeMillis();
        System.out.println("Testing BookRepositoryPanache (Quarkus Panache) with " + iterations + " iterations:");
        System.out.println("Starting Time: " + startTime);
        for (int i = 0; i < iterations; i++) {
            String title = "Alex Rider " + i;
            Book book = new Book();
            book.setTitle(title);

            bookRepositoryPanache.persist(book);
            List<Book> byTitle = bookRepositoryPanache.findByTitle(title);
            assertNotNull(byTitle);
            assertEquals(1, byTitle.size());
            assertEquals(title, byTitle.getFirst().getTitle());
        }

        endTime = System.currentTimeMillis();
        System.out.println("Ending Time: " + endTime);
        long duration = endTime - startTime;
        System.out.println("Total Time taken for " + iterations + " iterations: " + duration);
    }
}