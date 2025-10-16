package org.ahmsa.bookshelf.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BookDto extends BookBaseDto implements IDto<Book> {
    private List<GenreBaseDto> genres;
    private List<AuthorBaseDto> authors;

    public BookDto(Book book) {
        super(book);
        this.genres = book.getGenres() != null? book.getGenres().stream().map(GenreBaseDto::new).toList(): null;
        this.authors = book.getAuthors() != null? book.getAuthors().stream().map(AuthorBaseDto::new).toList(): null;
    }

    @Override
    public void populateFromEntity(Book book) {
        super.populateFromEntity(book);
        this.genres = book.getGenres() != null? book.getGenres().stream().map(GenreBaseDto::new).toList(): null;
        this.authors = book.getAuthors() != null? book.getAuthors().stream().map(AuthorBaseDto::new).toList(): null;
    }

    @Override
    public Book getEntity() {
        Book book = super.getEntity();
        book.setGenres(this.genres != null? this.genres.stream().map(GenreBaseDto::getEntity).toList(): null);
        book.setAuthors(this.authors != null? this.authors.stream().map(AuthorBaseDto::getEntity).toList(): null);
        return book;
    }

    @Override
    public Book updateEntity(Book book) {
        super.updateEntity(book);
        book.setGenres(this.genres != null? this.genres.stream().map(GenreBaseDto::getEntity).toList(): null);
        book.setAuthors(this.authors != null? this.authors.stream().map(AuthorBaseDto::getEntity).toList(): null);
        return book;
    }
}
