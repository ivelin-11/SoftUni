package com.example.springintro.service;

import com.example.springintro.model.entity.Author;
import com.example.springintro.model.entity.AuthorNameWithTotalCopies;

import java.io.IOException;
import java.util.List;

public interface AuthorService {
    void seedAuthors() throws IOException;

    Author getRandomAuthor();

    List<String> getAllAuthorsOrderByCountOfTheirBooks();


    List<Author> getAuthorsFirstNameEndsWith(String endsWith);

    List<AuthorNameWithTotalCopies> getAuthorsWithBooksCountSaledCopies();

    void createProcedureForGettingWrittenBooksCount();

    long callProcedureGET_AUTHOR_WRITTEN_BOOKS_COUNT(String firstName,String LastName);
}
