package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.Book;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;
import java.util.Optional;
@RepositoryRestResource(exported =false)
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByTitle(String title);

    List<Book> findByAuthor(String author);

}
