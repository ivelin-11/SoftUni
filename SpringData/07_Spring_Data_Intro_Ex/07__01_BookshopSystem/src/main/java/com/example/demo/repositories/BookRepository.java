package com.example.demo.repositories;

import com.example.demo.entities.Author;
import com.example.demo.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {

   List<Book> findAllByReleaseDateAfter(LocalDate date);

}
