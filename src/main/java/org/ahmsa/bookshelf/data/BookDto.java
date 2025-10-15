package org.ahmsa.bookshelf.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BookDto extends BookBaseDto {
    private List<GenreBaseDto> genres;
    private List<AuthorBaseDto> authors;

    public BookDto(Book book) {
        super(book);
        this.genres = book.getGenres() != null? book.getGenres().stream().map(GenreBaseDto::new).toList(): null;
        this.authors = book.getAuthors() != null? book.getAuthors().stream().map(AuthorBaseDto::new).toList(): null;
    }
}
