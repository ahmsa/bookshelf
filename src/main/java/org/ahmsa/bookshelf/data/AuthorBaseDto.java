package org.ahmsa.bookshelf.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthorBaseDto implements IDto<Author> {
    private String id;
    private String name;
    private String country;

    public AuthorBaseDto(Author author) {
        this.id = author.getId();
        this.name = author.getName();
        this.country = author.getCountry();
    }

    @Override
    public void populateFromEntity(Author author) {
        this.id = author.getId();
        this.name = author.getName();
        this.country = author.getCountry();
    }

    @Override
    public Author getEntity() {
        Author author = new Author();
        author.setId(this.id);
        author.setName(this.name);
        author.setCountry(this.country);
        return author;
    }

    @Override
    public Author updateEntity(Author author) {
        author.setName(this.name);
        author.setCountry(this.country);
        return author;
    }
}
