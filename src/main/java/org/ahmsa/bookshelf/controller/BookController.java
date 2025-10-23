package org.ahmsa.bookshelf.controller;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.ahmsa.bookshelf.data.Book;
import org.ahmsa.bookshelf.data.BookDto;
import org.ahmsa.bookshelf.service.BookService;
import org.ahmsa.bookshelf.service.IService;

import java.util.List;

@Path("/books")
public class BookController extends BaseController<Book, BookDto> {
    @Inject
    BookService bookService;

    @Override
    public IService getServiceClass() {
        return this.bookService;
    }

    @GET
    @Path("/findByTitle") // Defines a sub-path for this method
    @Produces(MediaType.APPLICATION_JSON)
    public List<BookDto> findByTitle(@QueryParam("title") String title) {
        return bookService.getByTitle(title);
    }
}
