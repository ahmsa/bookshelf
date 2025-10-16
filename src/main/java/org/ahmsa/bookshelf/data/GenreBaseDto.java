package org.ahmsa.bookshelf.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GenreBaseDto implements IDto<Genre> {
    private String id;
    private String name;

    public GenreBaseDto(Genre genre) {
        this.id = genre.getId();
        this.name = genre.getName();
    }

    @Override
    public void populateFromEntity(Genre genre) {
        this.id = genre.getId();
        this.name = genre.getName();
    }

    public Genre getEntity() {
        Genre genre = new Genre();
        genre.setId(this.id);
        genre.setName(this.name);
        return genre;
    }

    public Genre updateEntity(Genre genre) {
        genre.setName(this.name);
        return genre;
    }
}
