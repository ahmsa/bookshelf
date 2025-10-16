package org.ahmsa.bookshelf.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class GenreDto extends GenreBaseDto implements IDto {
    GenreBaseDto parentGenre;
    List<GenreBaseDto> subGenres;
    List<BookBaseDto> books;

    public GenreDto(Genre genre) {
        super(genre);

        if (genre.getParentGenre() != null) {
            this.parentGenre = new GenreBaseDto(genre.getParentGenre());
        }

        this.subGenres = genre.getSubGenres() != null ? genre.getSubGenres().stream().map(GenreBaseDto::new).toList() : null;
        this.books = genre.getBooks() != null ? genre.getBooks().stream().map(BookBaseDto::new).toList() : null;
    }

    @JsonIgnore
    public Genre getEntity() {
        Genre genre = super.getEntity();

        if (this.parentGenre != null) {
            genre.setParentGenre(this.parentGenre.getEntity());
        }

        return genre;
    }
}
