package com.example.demo.services;

import com.example.demo.entities.*;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SeedServiceImpl implements SeedService {


    private final String separator = FileSystems.getDefault().getSeparator();
    private final String PATH_REFERENCE = "src" + separator +
            "main" + separator + "resources" + separator + "seed-files" + separator;

    private String AUTHORS_FILE_NAME = "authors.txt";

    private String CATEGORIES_FILE_NAME = "categories.txt";

    private final String BOOKS_FILE_NAME = "books.txt";

    private AuthorRepository authorRepository;

    private CategoryRepository categoryRepository;

    private BookRepository bookRepository;

    private AuthorService authorService;

    private CategoryService categoryService;


    @Autowired
    public SeedServiceImpl(AuthorRepository authorRepository, CategoryRepository categoryRepository, BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedAuthors() throws IOException {

        Files.readAllLines(Path.of(PATH_REFERENCE + AUTHORS_FILE_NAME)).stream().
                filter(s -> !s.trim().isEmpty()).
                map(s -> s.split("\\s+"))
                .map(names -> new Author(names[0], names[1])).
                forEach(authorRepository::save);
    }

    @Override
    public void seedCategories() throws IOException {
        Files.readAllLines(Path.of(PATH_REFERENCE + CATEGORIES_FILE_NAME)).stream().
                filter(s -> !s.trim().isEmpty())
                .map(Category::new).
                forEach(categoryRepository::save);
    }

    @Override
    public void seedBooks() throws IOException {
        Files.readAllLines(Path.of(PATH_REFERENCE + BOOKS_FILE_NAME)).stream().
                filter(s ->! s.isBlank()).
                map(this::getBookObject).
                forEach(bookRepository::save);
    }

    private Book getBookObject(String line) {
        String[] bookParts = line.split("\\s+");

        int indexEditionType = Integer.parseInt(bookParts[0]);
        EditionType editionType = EditionType.values()[indexEditionType];

        LocalDate releaseDate = LocalDate.parse(bookParts[1], DateTimeFormatter.ofPattern("d/M/yyyy"));

        int copies = Integer.parseInt(bookParts[2]);

        BigDecimal price = new BigDecimal(bookParts[3]);

        int indexAgeRestriction = Integer.parseInt(bookParts[4]);

        AgeRestriction ageRestriction = AgeRestriction.values()[indexAgeRestriction];

        String title = Arrays.stream(bookParts).skip(5).collect(Collectors.joining(" "));

        Author author = authorService.getRandomAuthor();

        Set<Category> categories = this.categoryService.getRandomCategories();

        return new Book(title, editionType, price, copies, releaseDate, ageRestriction, author, categories);
    }
}
