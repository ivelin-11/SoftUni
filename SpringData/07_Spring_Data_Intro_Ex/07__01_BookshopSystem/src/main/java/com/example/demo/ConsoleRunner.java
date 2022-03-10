package com.example.demo;

import com.example.demo.entities.Author;
import com.example.demo.entities.Book;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import com.example.demo.services.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final SeedService seedService;
    private final BookRepository bookRepository;
    private AuthorRepository authorRepository;

    @Autowired
    public ConsoleRunner(SeedService seedService, BookRepository bookRepository, AuthorRepository authorRepository) {
        this.seedService = seedService;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    private void _01_BooksAfter2000() {
        LocalDate year2000 = LocalDate.parse("2000-12-31");

        List<Book> books = this.bookRepository.findAllByReleaseDateAfter(year2000);

        books.forEach(b -> System.out.println(b.getTitle()));
        System.out.println(books.size());
    }

    private void _02_AllAuthorsWithBooksBefore1990() {
        LocalDate year1990 = LocalDate.parse("1990-01-01");

        List<Author> authors = this.authorRepository.findAllDistinctByBooksReleaseDateBefore(year1990);

        authors.stream().forEach(a -> System.out.println(a.getFirstName() + " " + a.getLastName()));

        System.out.println(authors.stream().count());
    }

    private void _03_AllBooksOrderedByBooksCount() {
        List<Author> authors = this.authorRepository.findAll();

        Comparator<Author> authorComparator = Comparator.comparingInt(a -> a.getBooks().size());
        authors.stream().sorted(authorComparator.reversed()).forEach(a -> System.out.println(a.getFirstName() + " " + a.getLastName() + " " + a.getBooks().size()
        ));
    }

    private void _04_AllBooksFromGeorgePowellOrderByReleaseDateDescAndBookTitleAsc() {

        Author author = this.authorRepository.findAllByFirstNameAndLastName("George", "Powell");

        Comparator<Book> bookComparator = new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                int compareDates = b2.getReleaseDate().compareTo(b1.getReleaseDate());
                if (compareDates != 0) {
                    return compareDates;
                }

             return b1.getTitle().compareTo(b2.getTitle());
            }
        };

        author.getBooks().stream().sorted(bookComparator).
        forEach(b -> System.out.println(b.getTitle() + " " + b.getReleaseDate() + " " + b.getCopies()));
    }


    @Override
    public void run(String... args) throws Exception {
//        this.seedService.seedAuthors();
//        this.seedService.seedCategories();
//        this.seedService.seedBooks();

        //  this._01_BooksAfter2000();
//     this._02_AllAuthorsWithBooksBefore1990();
//      this._03_AllBooksOrderedByBooksCount();
        this._04_AllBooksFromGeorgePowellOrderByReleaseDateDescAndBookTitleAsc();
    }


}
