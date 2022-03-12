package com.example.springintro.repository;

import com.example.springintro.model.entity.Author;
import com.example.springintro.model.entity.AuthorNameWithTotalCopies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a ORDER BY a.books.size DESC")
    List<Author> findAllByBooksSizeDESC();


    List<Author> findAllAuthorsByFirstNameEndingWith(String endsWith);

    @Query("SELECT a.firstName as firstName,a.lastName as lastName,SUM(b.copies) AS totalCopies "
            +"FROM Author a "
            +"JOIN a.books AS b "
            +"GROUP BY a.id "
            +"ORDER BY totalCopies DESC")
    List<AuthorNameWithTotalCopies> findAllAuthorsWithCountSaledCopies();
}
