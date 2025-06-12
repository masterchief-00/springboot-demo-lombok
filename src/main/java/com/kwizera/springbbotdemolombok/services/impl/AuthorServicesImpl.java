package com.kwizera.springbbotdemolombok.services.impl;

import com.kwizera.springbbotdemolombok.domain.entities.Author;
import com.kwizera.springbbotdemolombok.repositories.AuthorRepository;
import com.kwizera.springbbotdemolombok.services.AuthorServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
