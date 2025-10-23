package org.ahmsa.bookshelf.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.ahmsa.bookshelf.data.Author;
import org.ahmsa.bookshelf.data.AuthorDto;
import org.ahmsa.bookshelf.data.IDto;
import org.ahmsa.bookshelf.repository.AuthorRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@ApplicationScoped
public class AuthorService implements IService<Author, AuthorDto> {
    @Inject
    AuthorRepository authorRepository;

    @Override
    public CrudRepository<Author, Long> getCrudRepository() {
        return this.authorRepository;
    }

    @Override
    public AuthorDto getDtoInstance() {
        return new AuthorDto();
    }

    public List<AuthorDto> findByName(String firstName) {
        List<Author> authors = authorRepository.findByName(firstName);
        if(authors == null || authors.isEmpty()){
            return List.of();
        }
        return authors.stream().map(AuthorDto::new).toList();
    }
}
