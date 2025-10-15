package org.ahmsa.bookshelf.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookBaseDto {
    private String id;
    private String title;
    private Integer publicationYear;
    private Double edition;
    private Double price;
    private String bookLanguage;
    private String publisher;
    private String isbn;

    public BookBaseDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.publicationYear = book.getPublicationYear();
        this.edition = book.getEdition();
        this.price = book.getPrice();
        this.bookLanguage = book.getBookLanguage();
        this.publisher = book.getPublisher();
        this.isbn = book.getIsbn();
    }
}
