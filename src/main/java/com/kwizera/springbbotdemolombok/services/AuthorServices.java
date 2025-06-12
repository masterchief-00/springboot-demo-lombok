package com.kwizera.springbbotdemolombok.services;

import com.kwizera.springbbotdemolombok.domain.entities.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorServices {
    Optional<Author> findAuthorById(long id);

    Author createAuthor(Author author);

    List<Author> findAllAuthors();

    Author updateAuthor(Long id, Author author);
}
