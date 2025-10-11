package org.ahmsa.bookshelf.service;

import org.ahmsa.bookshelf.data.Book;
import org.ahmsa.bookshelf.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class BookServiceTest {

    @Mock
    BookRepository bookRepositoryMock;

    @InjectMocks
    BookService bookService;

    @BeforeEach
    void setUp() throws Exception {
        try(AutoCloseable ac = MockitoAnnotations.openMocks(this)) {
        }
    }

    @Test
    void getByTitle() {
        Book book = new Book();
        book.setTitle("Book 1");

        when(bookRepositoryMock.findByTitle(any(String.class))).thenReturn(List.of(book));

        List<Book> byTitle = bookService.getByTitle("Book 1");
        assertNotNull(byTitle);
        assertEquals(1, byTitle.size());
        assertEquals("Book 1", byTitle.get(0).getTitle());
    }
}