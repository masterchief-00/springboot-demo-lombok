package com.kwizera.springbbotdemolombok.repositories;

import com.kwizera.springbbotdemolombok.domain.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
