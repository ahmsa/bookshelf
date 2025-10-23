package org.ahmsa.bookshelf.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ahmsa.bookshelf.util.EntityMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenreDtoTest {

    @Test
    void getEntity() {
    }

    @Test
    void getParentGenre() {
    }

    @Test
    void getSubGenres() {
    }

    @Test
    void getBooks() {
    }

    @Test
    void setParentGenre() {
    }

    @Test
    void setSubGenres() {
    }

    @Test
    void setBooks() {
    }

    @Test
    void getGenereAsString() throws JsonProcessingException {
        GenreDto genreDto = new GenreDto();
        genreDto.setName("Genre 1");
        String json = EntityMapper.objectToJsonString(genreDto);

        // Print the JSON string
        System.out.println(json);
    }
}