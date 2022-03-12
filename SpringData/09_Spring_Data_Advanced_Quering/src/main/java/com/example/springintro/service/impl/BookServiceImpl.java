package com.example.springintro.service.impl;

import com.example.springintro.model.entity.*;
import com.example.springintro.repository.BookRepository;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private static final String BOOKS_FILE_PATH = "src/main/resources/files/books.txt";

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedBooks() throws IOException {
        if (bookRepository.count() > 0) {
            return;
        }

        Files
                .readAllLines(Path.of(BOOKS_FILE_PATH))
                .forEach(row -> {
                    String[] bookInfo = row.split("\\s+");

                    Book book = createBookFromInfo(bookInfo);

                    bookRepository.save(book);
                });
    }

    @Override
    public List<Book> findAllBooksAfterYear(int year) {
        return bookRepository
                .findAllByReleaseDateAfter(LocalDate.of(year, 12, 31));
    }

    @Override
    public List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year) {
        return bookRepository
                .findAllByReleaseDateBefore(LocalDate.of(year, 1, 1))
                .stream()
                .map(book -> String.format("%s %s", book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName()))
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName) {
        return bookRepository
                .findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(firstName, lastName)
                .stream()
                .map(book -> String.format("%s %s %d",
                        book.getTitle(),
                        book.getReleaseDate(),
                        book.getCopies()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getBookTitlesByAgeRestriction(String ageRestriction) {
        AgeRestriction restriction = AgeRestriction.valueOf(ageRestriction.toUpperCase());

        return this.bookRepository.findAllByAgeRestriction(restriction).stream()
        .map(Book::getTitle).
        collect(Collectors.toList());
    }

    @Override
    public List<String> getBookTitlesGoldenEditionAndLessThan5000Copies() {
        return this.bookRepository.findAllBooksByEditionTypeAndCopiesLessThan(EditionType.GOLD,5000).stream()
                .map(Book::getTitle).collect(Collectors.toList());
    }

    @Override
    public List<Book> getBooksWithPriceLowerThanAndHigherThan(int lower,int upper) {
        return this.bookRepository.findAllBooksByPriceLessThanOrPriceGreaterThan(BigDecimal.valueOf(lower),
                BigDecimal.valueOf(upper));
    }

    @Override
    public List<String> getBookTitlesNotReleasedInYear(int year) {
        LocalDate beginDate=LocalDate.of(year,1,1);
        LocalDate endDate=LocalDate.of(year,12,31);
        return this.bookRepository.findAllBooksByReleaseDateLessThanOrReleaseDateGreaterThan(beginDate,endDate)
                .stream().map(Book::getTitle).collect(Collectors.toList());
    }

    @Override
    public List<Book> getBooksReleaseDateBefore(String dateString) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dateBefore = LocalDate.parse(dateString, formatter);

        return this.bookRepository.findAllBooksByReleaseDateBefore(dateBefore);
    }

    @Override
    public List<String> getBookTitlesContaining(String contain) {

       return  this.bookRepository.findAllBookByTitleContaining(contain).
                stream().map(Book::getTitle).collect(Collectors.toList());
    }

    @Override
    public List<Book> getBooksByAuthorsLastNameStartsWith(String lastNameStartsWith) {
        return
                this.bookRepository.findAllBookByAuthorLastNameStartingWith(lastNameStartsWith);
    }

    @Override
    public int countBooksWithTitleLongerThan(int titleMinimumLength) {
        return this.bookRepository.countBooksWithTitleLongerThan(titleMinimumLength);
    }

    @Override
    public BookSummary getBookSummaryByTitle(String title) {
     return  this.bookRepository.findBookSummaryByName(title);
    }


    private Book createBookFromInfo(String[] bookInfo) {
        EditionType editionType = EditionType.values()[Integer.parseInt(bookInfo[0])];
        LocalDate releaseDate = LocalDate
                .parse(bookInfo[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        Integer copies = Integer.parseInt(bookInfo[2]);
        BigDecimal price = new BigDecimal(bookInfo[3]);
        AgeRestriction ageRestriction = AgeRestriction
                .values()[Integer.parseInt(bookInfo[4])];
        String title = Arrays.stream(bookInfo)
                .skip(5)
                .collect(Collectors.joining(" "));

        Author author = authorService.getRandomAuthor();
        Set<Category> categories = categoryService
                .getRandomCategories();

        return new Book(editionType, releaseDate, copies, price, ageRestriction, title, author, categories);

    }
}
