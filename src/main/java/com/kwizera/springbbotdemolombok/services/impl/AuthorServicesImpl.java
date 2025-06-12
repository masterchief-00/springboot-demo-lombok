package com.kwizera.springbbotdemolombok.services.impl;

import com.kwizera.springbbotdemolombok.domain.entities.Author;
import com.kwizera.springbbotdemolombok.repositories.AuthorRepository;
import com.kwizera.springbbotdemolombok.services.AuthorServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthorServicesImpl implements AuthorServices {
    private final AuthorRepository authorRepository;

    @Override
    public Optional<Author> findAuthorById(long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author updateAuthor(Long id, Author author) {
        return authorRepository.findById(id).map(a -> {
            a.setName(author.getName());
            return authorRepository.save(author);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found"));
    }

}
