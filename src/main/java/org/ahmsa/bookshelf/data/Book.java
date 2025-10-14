package org.ahmsa.bookshelf.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(generator = "uuid")
    private String id;
    private String title;
    private Integer publicationYear;
    private Double edition;
    private Double price;
    private String Language;
    private String publisher;
    private String isbn;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Genre> genres;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Author> authors;
}
