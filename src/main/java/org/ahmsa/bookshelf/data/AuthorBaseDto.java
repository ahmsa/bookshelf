package org.ahmsa.bookshelf.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthorBaseDto {
    private String id;
    private String name;
    private String nationality;

    public AuthorBaseDto(Author author) {
        this.id = author.getId();
        this.name = author.getName();
        this.nationality = author.getNationality();
    }
}
