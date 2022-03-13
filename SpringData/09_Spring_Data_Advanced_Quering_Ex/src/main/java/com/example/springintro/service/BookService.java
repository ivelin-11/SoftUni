package com.example.springintro.service;

import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.BookSummary;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<String> getBookTitlesByAgeRestriction(String ageRestriction);

    List<String> getBookTitlesGoldenEditionAndLessThan5000Copies();


    List<Book>  getBooksWithPriceLowerThanAndHigherThan(int lower, int upper);

    List<String> getBookTitlesNotReleasedInYear(int year);

    List<Book> getBooksReleaseDateBefore(String date);

    List<String> getBookTitlesContaining(String contain);

    List<Book> getBooksByAuthorsLastNameStartsWith(String lastNameStartsWith);

    int countBooksWithTitleLongerThan(int titleMinimumLength);

    BookSummary getBookSummaryByTitle(String title);

    int updateNumberBooksAfterDate(String date, int number);

    int deleteByCopiesLessThan(int amount);


}
