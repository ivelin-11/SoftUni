package com.example.springintro.repository;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.BookSummary;
import com.example.springintro.model.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);

    List<Book> findAllByAgeRestriction(AgeRestriction restriction);

    List<Book> findAllBooksByEditionTypeAndCopiesLessThan(EditionType gold, int copies);

    List<Book> findAllBooksByPriceLessThanOrPriceGreaterThan(BigDecimal lower, BigDecimal upper);

    List<Book> findAllBooksByReleaseDateLessThanOrReleaseDateGreaterThan(LocalDate beginDate, LocalDate endDate);

    List<Book> findAllBooksByReleaseDateBefore(LocalDate dateBefore);

    List<Book> findAllBookByTitleContaining(String contain);

    List<Book> findAllBookByAuthorLastNameStartingWith(String lastNameStartsWith);


    @Query("SELECT COUNT(b) FROM Book b WHERE length(b.title) > :length")
    int countBooksWithTitleLongerThan(@Param("length") int titleMinimumLength);

    @Query("SELECT b.title as title, b.editionType as editionType, b.ageRestriction as ageRestriction, " +
            "b.price as price "+
            "FROM Book b " +
            "WHERE b.title = :title")
    BookSummary findBookSummaryByName(String title);
}
