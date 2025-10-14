package org.ahmsa.bookshelf.data;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
    private String Language;
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
        this.Language = book.getLanguage();
        this.publisher = book.getPublisher();
        this.isbn = book.getIsbn();
        this.genreIds = book.getGenres() != null? book.getGenres().stream().map(Genre::getId).toList(): null;
        this.authorIds = book.getAuthors() != null? book.getAuthors().stream().map(Author::getId).toList(): null;
    }
}
