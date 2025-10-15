package org.ahmsa.bookshelf.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthorDto extends AuthorBaseDto {
    AuthorDto(Author author) {
        super(author);
    }
}
