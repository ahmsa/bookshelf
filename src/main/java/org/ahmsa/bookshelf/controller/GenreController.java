package org.ahmsa.bookshelf.controller;


import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.ahmsa.bookshelf.data.Genre;
import org.ahmsa.bookshelf.data.GenreDto;
import org.ahmsa.bookshelf.service.GenreService;
import org.ahmsa.bookshelf.service.IService;

import java.util.List;

@Path("/genres")
public class GenreController extends BaseController<Genre, GenreDto> {
    @Inject
    GenreService genreService;

    @Override
    public IService getServiceClass() {
        return this.genreService;
    }
}
