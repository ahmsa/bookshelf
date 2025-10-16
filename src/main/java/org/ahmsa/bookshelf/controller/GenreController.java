package org.ahmsa.bookshelf.controller;


import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.ahmsa.bookshelf.data.GenreDto;
import org.ahmsa.bookshelf.service.GenreService;

import java.util.List;

@Path("/genres")
public class GenreController {
    @Inject
    GenreService genreService;

    @POST
    @Path("/save")
    public GenreDto save(GenreDto genre) {
        return this.genreService.saveGenre(genre);
    }

    @GET
    public List<GenreDto> getGenre() {
        return this.genreService.getAllGenres();
    }
}
