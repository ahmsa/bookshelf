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
public class GenreDto extends GenreBaseDto implements IDto<Genre> {
    GenreBaseDto parentGenre;
    List<GenreBaseDto> subGenres;
    List<BookBaseDto> books;

    public GenreDto(){
        super();
    }

    public GenreDto(Genre genre) {
        super(genre);

        if (genre.getParentGenre() != null) {
            this.parentGenre = new GenreBaseDto(genre.getParentGenre());
        }

        this.subGenres = genre.getSubGenres() != null ? genre.getSubGenres().stream().map(GenreBaseDto::new).toList() : null;
        this.books = genre.getBooks() != null ? genre.getBooks().stream().map(BookBaseDto::new).toList() : null;
    }

    public GenreBaseDto getParentGenre() {
        return parentGenre;
    }

    public void setParentGenre(GenreBaseDto parentGenre) {
        this.parentGenre = parentGenre;
    }

    public List<GenreBaseDto> getSubGenres() {
        return subGenres;
    }

    public void setSubGenres(List<GenreBaseDto> subGenres) {
        this.subGenres = subGenres;
    }

    public List<BookBaseDto> getBooks() {
        return books;
    }

    public void setBooks(List<BookBaseDto> books) {
        this.books = books;
    }

    @Override
    public void populateFromEntity(Genre genre) {
        super.populateFromEntity(genre);

        if (genre.getParentGenre() != null) {
            this.parentGenre = new GenreBaseDto(genre.getParentGenre());
        }

        this.subGenres = genre.getSubGenres() != null ? genre.getSubGenres().stream().map(GenreBaseDto::new).toList() : null;
        this.books = genre.getBooks() != null ? genre.getBooks().stream().map(BookBaseDto::new).toList() : null;
    }

    @Override
    public Genre getEntity() {
        Genre genre = super.getEntity();

        if (this.parentGenre != null) {
            genre.setParentGenre(this.parentGenre.getEntity());
        }

        return genre;
    }

    @Override
    public Genre updateEntity(Genre genre) {
        super.updateEntity(genre);

        if (this.parentGenre != null) {
            genre.setParentGenre(this.parentGenre.getEntity());
        }

        return genre;
    }
}
