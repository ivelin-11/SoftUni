package com.example.demo.repositories;

import com.example.demo.entities.Author;
import com.example.demo.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    List<Author> findAllDistinctByBooksReleaseDateBefore(LocalDate date);
    Author findAllByFirstNameAndLastName(String firstName, String lastName);
}
