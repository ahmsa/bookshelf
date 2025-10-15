package org.ahmsa.bookshelf.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BookDto {
    private String id;
    private String title;
    private Integer publicationYear;
    private Double edition;
    private Double price;
    private String bookLanguage;
    private String publisher;
    private String isbn;
    private List<String> genreIds;
    private List<String> authorIds;

    public BookDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.publicationYear = book.getPublicationYear();
        this.edition = book.getEdition();
        this.price = book.getPrice();
        this.bookLanguage = book.getBookLanguage();
        this.publisher = book.getPublisher();
        this.isbn = book.getIsbn();
        this.genreIds = book.getGenres() != null? book.getGenres().stream().map(Genre::getId).toList(): null;
        this.authorIds = book.getAuthors() != null? book.getAuthors().stream().map(Author::getId).toList(): null;
    }
}
