package org.ahmsa.bookshelf.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.ahmsa.bookshelf.data.AuthorDto;
import org.ahmsa.bookshelf.service.AuthorService;

@Path("/authors")
public class AuthorController {
    @Inject
    AuthorService authorService;

    @POST
    @Path("/save")
    public AuthorDto saveAuthor(AuthorDto authorDto) {
        return this.authorService.save(authorDto);
    }

    @GET
    public java.util.List<AuthorDto> getAllAuthors() {
        return this.authorService.findAll();
    }

    @GET
    @Path("/findByName")
    public java.util.List<AuthorDto> findByName(String firstName) {
        return this.authorService.findByName(firstName);
    }
}
