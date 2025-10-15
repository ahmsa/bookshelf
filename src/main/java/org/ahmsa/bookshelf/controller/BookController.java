package org.ahmsa.bookshelf.controller;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.ahmsa.bookshelf.data.BookBaseDto;
import org.ahmsa.bookshelf.data.BookDto;
import org.ahmsa.bookshelf.service.BookService;

import java.util.List;

@Path("/books")
public class BookController {
    @Inject
    BookService bookService;

    @GET
    @Path("/findByTitle") // Defines a sub-path for this method
    @Produces(MediaType.APPLICATION_JSON)
    public List<BookDto> findByTitle(@QueryParam("title") String title) {
        return bookService.getByTitle(title);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BookDto> getAllBooks() {
        // This method would call a service to get all books
        return bookService.getAllBooks();
    }

    @POST
    @Path("/addBook")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public BookDto addBook(BookDto bookDto) {
        // This method would call a service to add a new book
        return bookDto; // Placeholder return
    }
}
