package com.kwizera.springbbotdemolombok.services.impl;

import com.kwizera.springbbotdemolombok.domain.entities.Author;
import com.kwizera.springbbotdemolombok.domain.entities.Book;
import com.kwizera.springbbotdemolombok.repositories.BookRepository;
import com.kwizera.springbbotdemolombok.services.BookServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookServicesImpl implements BookServices {
    private final BookRepository bookRepository;

    @Override
    public Book createBook(Author author, Book book) {
        book.setAuthor(author);
        return bookRepository.save(book);
    }
}
