package org.ahmsa.bookshelf.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.ahmsa.bookshelf.data.Author;
import org.ahmsa.bookshelf.data.AuthorDto;
import org.ahmsa.bookshelf.repository.AuthorRepository;

import java.util.List;

@ApplicationScoped
public class AuthorService {
    @Inject
    AuthorRepository authorRepository;

    public List<AuthorDto> findAll() {
        List<Author> allAuthors = authorRepository.findAll();

        if(allAuthors == null || allAuthors.isEmpty()){
            return List.of();
        }
        return allAuthors.stream().map(AuthorDto::new).toList();
    }

    public List<AuthorDto> findByName(String firstName) {
        List<Author> authors = authorRepository.findByName(firstName);
        if(authors == null || authors.isEmpty()){
            return List.of();
        }
        return authors.stream().map(AuthorDto::new).toList();
    }

    public AuthorDto save(AuthorDto authorDto) {
        Author savedAuthor = authorRepository.save(authorDto.getEntity());
        return new AuthorDto(savedAuthor);
    }
}
