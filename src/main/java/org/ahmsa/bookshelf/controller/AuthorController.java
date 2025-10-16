package org.ahmsa.bookshelf.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import org.ahmsa.bookshelf.data.Author;
import org.ahmsa.bookshelf.data.AuthorDto;
import org.ahmsa.bookshelf.service.AuthorService;
import org.ahmsa.bookshelf.service.IService;

import java.util.List;

@Path("/authors")
public class AuthorController extends BaseController<Author, AuthorDto> {
    @Inject
    AuthorService authorService;

    @Override
    public IService getServiceClass() {
        return this.authorService;
    }

    @GET
    @Path("/findByName")
    public java.util.List<AuthorDto> findByName(String firstName) {
        return this.authorService.findByName(firstName);
    }
}
