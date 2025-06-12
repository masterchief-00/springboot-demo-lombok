package com.kwizera.springbbotdemolombok.services;

import com.kwizera.springbbotdemolombok.domain.entities.Author;

import java.util.Optional;

public interface AuthorServices {
    Optional<Author> findAuthorById(long id);

    Author createAuthor(Author author);
}
