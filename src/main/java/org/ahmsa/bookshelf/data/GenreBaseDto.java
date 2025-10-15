package org.ahmsa.bookshelf.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GenreBaseDto {
    private String id;
    private String name;
    private GenreBaseDto parentGenre;

    public GenreBaseDto(Genre genre) {
        this.id = genre.getId();
        this.name = genre.getName();
        if (genre.getParentGenre() != null) {
            this.parentGenre = new GenreBaseDto(genre.getParentGenre());
        }
    }
}
