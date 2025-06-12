package com.kwizera.springbbotdemolombok.controllers;

import com.kwizera.springbbotdemolombok.domain.entities.Author;
import com.kwizera.springbbotdemolombok.domain.entities.Book;
import com.kwizera.springbbotdemolombok.repositories.AuthorRepository;
import com.kwizera.springbbotdemolombok.repositories.BookRepository;
import com.kwizera.springbbotdemolombok.services.AuthorServices;
import com.kwizera.springbbotdemolombok.services.BookServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping
    public List<Book> getAllBooks() {
        return bookServices.findAll();
    }

    @GetMapping("/{id")
    public Book getBook(@RequestParam Long bookId) {
        Optional<Book> book = bookServices.findBook(bookId);
        return book.orElse(null);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestParam(required = false) Long authorId, @RequestBody Book updatedBook) {
        return bookServices.updateBook(id, authorId, updatedBook);
    }
}
