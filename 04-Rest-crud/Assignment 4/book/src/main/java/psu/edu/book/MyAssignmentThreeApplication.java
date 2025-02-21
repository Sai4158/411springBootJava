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
            
         // Update BookID 101 to 2024
            updateBook(bookReportDao);
            
//          Deleting ID 102
            deleteBook(bookReportDao);

//           After changes
            retrieveAllData(bookReportDao);

        };
    }

    // Insert data 
    private void insertSampleData(BookReportDao bookReportDao) {
        System.out.println("Inserting book report data...");

     // Added books here
        BookReport book1 = new BookReport(1, 101, 21.99, 1, LocalDateTime.of(2023, 1, 1, 10, 0));
        BookReport book2 = new BookReport(2, 102, 15.50, 2, LocalDateTime.of(2023, 1, 2, 11, 0));
        BookReport book3 = new BookReport(3, 103, 10.99, 1, LocalDateTime.of(2023, 1, 3, 12, 0));
        BookReport book4 = new BookReport(4, 104, 25.75, 3, LocalDateTime.of(2023, 1, 4, 13, 0));
        BookReport book5 = new BookReport(5, 105, 18.20, 1, LocalDateTime.of(2023, 1, 5, 14, 0));
        BookReport book6 = new BookReport(6, 106, 12.30, 2, LocalDateTime.of(2023, 1, 6, 15, 0));
        BookReport book7 = new BookReport(7, 107, 9.99, 4, LocalDateTime.of(2023, 1, 7, 16, 0));
        BookReport book8 = new BookReport(8, 108, 30.50, 1, LocalDateTime.of(2023, 1, 8, 17, 0));
        BookReport book9 = new BookReport(9, 109, 22.15, 3, LocalDateTime.of(2023, 1, 9, 18, 0));
        BookReport book10 = new BookReport(10, 110, 27.40, 2, LocalDateTime.of(2023, 1, 10, 19, 0));

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
    
    //update
    private void updateBook(BookReportDao bookReportDao) {
        int bookid = 101;
        System.out.println("Getting book with ID: " + bookid);

        List<BookReport> reports = bookReportDao.findByBookid(bookid);
            for (BookReport report : reports) {
                report.setBookid(2024);
                bookReportDao.update(report);
            }
    }

    //Delete BookID 102
    private void deleteBook(BookReportDao bookReportDao) {
        int bookid = 102;
        System.out.println("Deleting book with BookID: " + bookid);

        List<BookReport> reports = bookReportDao.findByBookid(bookid);
            for (BookReport report : reports) {
                bookReportDao.delete(report.getId());
           
        }
    }
}
