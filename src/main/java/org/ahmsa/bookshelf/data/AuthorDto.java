package org.ahmsa.bookshelf.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AuthorDto {
    private String id;
    private String name;
    private String nationality;

    public AuthorDto(Author author) {
        this.id = author.getId();
        this.name = author.getName();
        this.nationality = author.getNationality();
    }
}
