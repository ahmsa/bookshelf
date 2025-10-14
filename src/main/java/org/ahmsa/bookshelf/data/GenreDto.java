package org.ahmsa.bookshelf.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class GenreDto {
    private String id;
    private String name;
    private GenreDto parentGenre;
    private List<String> subGenreIds;

    public GenreDto(Genre genre) {
        this.id = genre.getId();
        this.name = genre.getName();
        if (genre.getParentGenre() != null) {
            this.parentGenre = new GenreDto(genre.getParentGenre());
        }
        if (genre.getSubGenres() != null) {
            this.subGenreIds = genre.getSubGenres().stream().map(Genre::getId).toList();
        }
    }
}
