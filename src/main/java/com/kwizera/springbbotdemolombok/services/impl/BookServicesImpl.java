package com.kwizera.springbbotdemolombok.services.impl;

import com.kwizera.springbbotdemolombok.domain.entities.Author;
import com.kwizera.springbbotdemolombok.domain.entities.Book;
import com.kwizera.springbbotdemolombok.repositories.BookRepository;
import com.kwizera.springbbotdemolombok.services.BookServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BookServicesImpl implements BookServices {
    private final BookRepository bookRepository;

    @Override
    public Book createBook(Author author, Book book) {
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findBook(long id) {
        return bookRepository.findById(id);
    }
}
