package psu.edu.CRUD_demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import psu.edu.CRUD_demo.entity.Employee;

@Repository
@Transactional  // Ensures all database operations run within a transaction
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findById(int theId) {
        return entityManager.find(Employee.class, theId);
    }

    @Override
    public Employee save(Employee theEmployee) {
        return entityManager.merge(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        Employee theEmployee = entityManager.find(Employee.class, theId);
        if (theEmployee != null) {
            entityManager.remove(theEmployee);
        }
    }

    @Override
    public void updateBookId(int oldId, int newId) {
        try {
            Employee book = entityManager.createQuery("SELECT e FROM Employee e WHERE e.bookId = :oldId", Employee.class)
                                         .setParameter("oldId", oldId)
                                         .getSingleResult();
            if (book != null) {
                book.setBookId(newId);
                entityManager.merge(book);
            }
        } catch (NoResultException e) {
            System.out.println("No employee found with bookId: " + oldId);
        }
    }

    @Override
    public void deleteByBookId(int bookId) {
        try {
            Employee book = entityManager.createQuery("SELECT e FROM Employee e WHERE e.bookId = :bookId", Employee.class)
                                         .setParameter("bookId", bookId)
                                         .getSingleResult();
            if (book != null) {
                entityManager.remove(book);
            }
        } catch (NoResultException e) {
            System.out.println("No employee found with bookId: " + bookId);
        }
    }
}
