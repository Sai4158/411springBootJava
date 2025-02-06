package psu.edu.book.dao;

import psu.edu.book.entity.BookReport;
import java.util.List;

public interface BookReportDao {
    void save(BookReport bookReport);
    List<BookReport> findAll();
    List<BookReport> findByBookid(int bookid);
}
