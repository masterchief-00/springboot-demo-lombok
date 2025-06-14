package com.kwizera.springbbotdemolombok.controllers;

import com.kwizera.springbbotdemolombok.domain.entities.Author;
import com.kwizera.springbbotdemolombok.domain.entities.Book;
import com.kwizera.springbbotdemolombok.repositories.AuthorRepository;
import com.kwizera.springbbotdemolombok.services.AuthorServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorServices authorServices;

    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorServices.createAuthor(author);
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorServices.findAllAuthors();
    }

    @GetMapping("/{authorId}")
    public Author getAuthor(@PathVariable Long authorId) {
        Optional<Author> author = authorServices.findAuthorById(authorId);
        return author.orElse(null);
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable Long id, @RequestBody Author updatedAuthor) {
        return authorServices.updateAuthor(id, updatedAuthor);
    }
}
