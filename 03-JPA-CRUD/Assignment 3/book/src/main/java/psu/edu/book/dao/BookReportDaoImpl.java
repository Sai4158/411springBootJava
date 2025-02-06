package psu.edu.book.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import psu.edu.book.entity.BookReport;

import java.util.List;

@Repository
public class BookReportDaoImpl implements BookReportDao {

    private final EntityManager entityManager;

    @Autowired
    public BookReportDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(BookReport bookReport) {
        entityManager.merge(bookReport);  
    }

    @Override
    public List<BookReport> findAll() {
        TypedQuery<BookReport> query = entityManager.createQuery("FROM BookReport", BookReport.class);
        return query.getResultList();
    }

    @Override
    public List<BookReport> findByBookid(int bookid) {
        TypedQuery<BookReport> query = entityManager.createQuery("FROM BookReport WHERE bookid = :bookid", BookReport.class);
        query.setParameter("bookid", bookid);
        return query.getResultList();
    }
}
