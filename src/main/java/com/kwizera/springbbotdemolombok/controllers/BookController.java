package com.kwizera.springbbotdemolombok.controllers;

import com.kwizera.springbbotdemolombok.domain.entities.Author;
import com.kwizera.springbbotdemolombok.domain.entities.Book;
import com.kwizera.springbbotdemolombok.repositories.AuthorRepository;
import com.kwizera.springbbotdemolombok.repositories.BookRepository;
import com.kwizera.springbbotdemolombok.services.AuthorServices;
import com.kwizera.springbbotdemolombok.services.BookServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final AuthorServices authorServices;
    private final BookServices bookServices;

    @PostMapping
    public Book createBook(@RequestParam Long authorId, @RequestBody Book book) {
        Optional<Author> author = authorServices.findAuthorById(authorId);
        return author.map(value -> bookServices.createBook(value, book)).orElse(null);
    }
}
