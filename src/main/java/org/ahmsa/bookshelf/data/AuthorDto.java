package org.ahmsa.bookshelf.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AuthorDto extends AuthorBaseDto implements  IDto<Author> {
    List<BookBaseDto> books;

    public AuthorDto() {
        super();
    }

    public List<BookBaseDto> getBooks() {
        return books;
    }

    public void setBooks(List<BookBaseDto> books) {
        this.books = books;
    }

    public AuthorDto(Author author) {
        super(author);
        if (author.getBooks() != null) {
            this.books = author.getBooks().stream().map(BookBaseDto::new).toList();
        }
    }

    @Override
    public void populateFromEntity(Author author) {
        super.populateFromEntity(author);
        if (author.getBooks() != null) {
            this.books = author.getBooks().stream().map(BookBaseDto::new).toList();
        }
    }

    @Override
    public Author getEntity() {
        Author author = super.getEntity();

        if(this.getBooks() != null) {
            author.setBooks(this.getBooks().stream().map(BookBaseDto::getEntity).toList());
        }

        return author;
    }
}
