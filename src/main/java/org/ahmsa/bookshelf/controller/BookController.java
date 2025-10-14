package org.ahmsa.bookshelf.controller;


import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
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
}
