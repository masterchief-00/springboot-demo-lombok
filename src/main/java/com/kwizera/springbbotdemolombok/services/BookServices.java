package com.kwizera.springbbotdemolombok.services;

import com.kwizera.springbbotdemolombok.domain.entities.Author;
import com.kwizera.springbbotdemolombok.domain.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookServices {
    Book createBook(Author author, Book book);

    List<Book> findAll();

    Optional<Book> findBook(long id);
}
