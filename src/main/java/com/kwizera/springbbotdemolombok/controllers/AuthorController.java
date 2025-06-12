package com.kwizera.springbbotdemolombok.controllers;

import com.kwizera.springbbotdemolombok.domain.entities.Author;
import com.kwizera.springbbotdemolombok.repositories.AuthorRepository;
import com.kwizera.springbbotdemolombok.services.AuthorServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorServices authorServices;

    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorServices.createAuthor(author);
    }
}
