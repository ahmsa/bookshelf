package org.ahmsa.bookshelf.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private Long id;
    private String title;
    private Integer publicationYear;
    private Double edition;
    private Double price;
//    private List<Genre> genres;
//    private List<Author> authors;
}
