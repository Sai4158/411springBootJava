package psu.edu.book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import psu.edu.book.dao.BookReportDao;
import psu.edu.book.entity.BookReport;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class MyAssignmentThreeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyAssignmentThreeApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(BookReportDao bookReportDao) {
        return runner -> {
            // Insert Data
            insertSampleData(bookReportDao);

            // Retrieve all data
            retrieveAllData(bookReportDao);

            // Retrieve a specific book by BookID 101
            retrieveBookById(bookReportDao, 101);
        };
    }

    // Insert data 
    private void insertSampleData(BookReportDao bookReportDao) {
        System.out.println("Inserting book report data...");

     // Added books here
        BookReport book1 = new BookReport(1, 103, 10.99, 1, LocalDateTime.of(2020, 2, 14, 12, 30));
        BookReport book2 = new BookReport(2, 104, 15.50, 2, LocalDateTime.of(2020, 2, 15, 14, 15));
        BookReport book3 = new BookReport(3, 101, 21.99, 1, LocalDateTime.of(2020, 2, 15, 19, 10));
        BookReport book4 = new BookReport(4, 105, 8.99, 3, LocalDateTime.of(2020, 2, 16, 10, 0));
        BookReport book5 = new BookReport(5, 106, 12.75, 1, LocalDateTime.of(2020, 2, 16, 15, 45));
        BookReport book6 = new BookReport(6, 107, 9.50, 4, LocalDateTime.of(2020, 2, 17, 11, 20));
        BookReport book7 = new BookReport(7, 108, 14.99, 2, LocalDateTime.of(2020, 2, 17, 16, 10));
        BookReport book8 = new BookReport(8, 109, 18.25, 1, LocalDateTime.of(2020, 2, 18, 9, 30));
        BookReport book9 = new BookReport(9, 110, 20.00, 5, LocalDateTime.of(2020, 2, 18, 14, 0));
        BookReport book10 = new BookReport(10, 111, 11.49, 2, LocalDateTime.of(2020, 2, 19, 12, 15));

        bookReportDao.save(book1);
        bookReportDao.save(book2);
        bookReportDao.save(book3);
        bookReportDao.save(book4);
        bookReportDao.save(book5);
        bookReportDao.save(book6);
        bookReportDao.save(book7);
        bookReportDao.save(book8);
        bookReportDao.save(book9);
        bookReportDao.save(book10);


        System.out.println("Data inserted successfully.");
    }

    // Retrieve all records
    private void retrieveAllData(BookReportDao bookReportDao) {
        System.out.println("Retrieving all book reports...");
        List<BookReport> reports = bookReportDao.findAll();
        for (BookReport report : reports) {
            System.out.println(report);
        }
    }

    // Retrieve a specific book report by BookID 101
    private void retrieveBookById(BookReportDao bookReportDao, int bookid) {
        System.out.println("Retrieving book report for BookID: " + bookid);
        List<BookReport> reports = bookReportDao.findByBookid(bookid);
        for (BookReport report : reports) {
            System.out.println(report);
        }
    }
}
