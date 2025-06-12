package com.kwizera.springbbotdemolombok.services;

import com.kwizera.springbbotdemolombok.domain.entities.Author;
import com.kwizera.springbbotdemolombok.domain.entities.Book;

public interface BookServices {
    Book createBook(Author author, Book book);
}
