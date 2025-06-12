package com.kwizera.springbbotdemolombok.repositories;

import com.kwizera.springbbotdemolombok.domain.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
