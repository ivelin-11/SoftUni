package com.example.springintro.repository;

import com.example.springintro.model.entity.Author;
import com.example.springintro.model.entity.AuthorNameWithTotalCopies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    @Modifying
    @Transactional
    @Query(value = "CREATE PROCEDURE `GET_AUTHOR_WRITTEN_BOOKS_COUNT` " +
            "(`first` VARCHAR(50),`last` VARCHAR(50) ) "+
            "BEGIN "+
            "SELECT COUNT(b.id) AS count_books FROM authors AS a " +
            "JOIN books AS b ON b.author_id=a.id " +
            "WHERE a.first_name LIKE first AND a.last_name LIKE last "
            +"GROUP BY a.id; "
            +"END",nativeQuery = true)
    void createStoredProcedureGetWrittenBooksCount();

    @Query(value = "CALL GET_AUTHOR_WRITTEN_BOOKS_COUNT(:first,:last)",nativeQuery = true)
    long callGetWrittenBooksCount(@Param("first") String firstName,
                                 @Param("last") String lastName);
}
