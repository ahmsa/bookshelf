package org.ahmsa.bookshelf.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookBaseDto implements IDto<Book> {
    private Long id;
    private String title;
    private Integer publicationYear;
    private Double edition;
    private Double price;
    private String bookLanguage;
    private String publisher;
    private String isbn;

    public BookBaseDto(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public Double getEdition() {
        return edition;
    }

    public void setEdition(Double edition) {
        this.edition = edition;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBookLanguage() {
        return bookLanguage;
    }

    public void setBookLanguage(String bookLanguage) {
        this.bookLanguage = bookLanguage;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

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

    @Override
    public void populateFromEntity(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.publicationYear = book.getPublicationYear();
        this.edition = book.getEdition();
        this.price = book.getPrice();
        this.bookLanguage = book.getBookLanguage();
        this.publisher = book.getPublisher();
        this.isbn = book.getIsbn();
    }

    @Override
    public Book getEntity() {
        Book book = new Book();
        book.setId(this.id);
        book.setTitle(this.title);
        book.setPublicationYear(this.publicationYear);
        book.setEdition(this.edition);
        book.setPrice(this.price);
        book.setBookLanguage(this.bookLanguage);
        book.setPublisher(this.publisher);
        book.setIsbn(this.isbn);
        return book;
    }

    @Override
    public Book updateEntity(Book book) {
        book.setTitle(this.title);
        book.setPublicationYear(this.publicationYear);
        book.setEdition(this.edition);
        book.setPrice(this.price);
        book.setBookLanguage(this.bookLanguage);
        book.setPublisher(this.publisher);
        book.setIsbn(this.isbn);
        return book;
    }
}
