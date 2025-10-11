package org.ahmsa.bookshelf.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
    @GeneratedValue(generator = "uuid")
    private String id;
    private String title;
    private Integer publicationYear;
    private Double edition;
    private Double price;
//    private List<Genre> genres;
//    private List<Author> authors;
}
