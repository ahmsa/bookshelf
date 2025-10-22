package org.ahmsa.bookshelf.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.ahmsa.bookshelf.util.EntityMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthorDtoTest {
    @Test
    void getAuthorJson() throws JsonProcessingException {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId("1");
        authorDto.setName("John Doe");
        authorDto.setCountry("American");

        String json = EntityMapper.objectToJsonString(authorDto);

        System.out.println(json);
    }

}