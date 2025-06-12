package com.kwizera.springbbotdemolombok.services.impl;

import com.kwizera.springbbotdemolombok.domain.entities.Author;
import com.kwizera.springbbotdemolombok.domain.entities.Book;
import com.kwizera.springbbotdemolombok.repositories.AuthorRepository;
import com.kwizera.springbbotdemolombok.repositories.BookRepository;
import com.kwizera.springbbotdemolombok.services.BookServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BookServicesImpl implements BookServices {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

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

    @Override
    public Book updateBook(long bookId, Long authorId, Book book) {
        return bookRepository.findById(bookId).map(b -> {
            b.setTitle(b.getTitle());

            if (authorId != null) {
                Author newAuthor = authorRepository.findById(authorId)
                        .orElseThrow(ResolutionException::new);
                book.setAuthor(newAuthor);
            }

            return bookRepository.save(book);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
    }
}
