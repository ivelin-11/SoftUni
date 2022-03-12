package com.example.springintro;

import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.BookSummary;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;


    @Autowired
    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
//        seedData();

        //11
        String title= scanner.nextLine();
        BookSummary bookSummaryByTitle = this.bookService.getBookSummaryByTitle(title);
        System.out.printf("%s %s %s %.2f%n",
                bookSummaryByTitle.getTitle(),bookSummaryByTitle.getEditionType(), bookSummaryByTitle.getAgeRestriction(),bookSummaryByTitle.getPrice());

        //10
//this.authorService.getAuthorsWithBooksCountSaledCopies().
//        forEach(a-> System.out.println(a.getFirstName()+" "+a.getLastName()+" - "+a.getTotalCopies()));


        //09
//        int titleMinimumLength=Integer.parseInt(scanner.nextLine());
//        System.out.println(this.bookService.countBooksWithTitleLongerThan(titleMinimumLength));


        //08
//        String lastNameStartsWith = scanner.nextLine();
//       this.bookService.getBooksByAuthorsLastNameStartsWith(lastNameStartsWith).
//               forEach(b -> System.out.println(b.getTitle() + " ("+b.getAuthor().getFirstName()+
//                       " "+b.getAuthor().getLastName()+")"));


        //07
//        String contain = scanner.nextLine();
//       this.bookService.getBookTitlesContaining(contain).forEach(System.out::println);


//        06
//        String endsWith= scanner.nextLine();
//        this.authorService.getAuthorsFirstNameEndsWith(endsWith).
//                forEach(a-> System.out.println(a.getFirstName()+" "+a.getLastName()));


//        05
//        String date = scanner.nextLine();
//        this.bookService.getBooksReleaseDateBefore(date)
//                .forEach(b-> System.out.println(b.getTitle()+ " "+b.getEditionType()+" "+b.getPrice()));


        //04
//        int year= Integer.parseInt(scanner.nextLine());
//        this.bookService.getBookTitlesNotReleasedInYear(year).
//        forEach(System.out::println);


        //03
//        this.bookService.getBooksWithPriceLowerThanAndHigherThan(5,40).
//        forEach(b-> System.out.println(b.getTitle()+" - $"+b.getPrice() ));


        //02
//        this.bookService.getBookTitlesGoldenEditionAndLessThan5000Copies().forEach(System.out::println);


        //01
//        String restriction = scanner.nextLine();
//      this.bookService.getBookTitlesByAgeRestriction(restriction).forEach(System.out::println);


        //printAllBooksAfterYear(2000);
//        printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
        //   printAllAuthorsAndNumberOfTheirBooks();
//        pritnALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");

    }

    private void pritnALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
