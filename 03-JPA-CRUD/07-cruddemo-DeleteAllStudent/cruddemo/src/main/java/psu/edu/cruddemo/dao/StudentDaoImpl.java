package psu.edu.cruddemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import psu.edu.cruddemo.entity.Student;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    private final EntityManager entityManager;

    @Autowired
    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // Create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

        // Return query results
        return theQuery.getResultList();
    }
    
    @Override
    public List<Student> findByLastName(String lastName) {  
        TypedQuery<Student> theQuery = entityManager.createQuery(
                "FROM Student s WHERE s.lastName = :lastName", Student.class);
        theQuery.setParameter("lastName", lastName);
        return theQuery.getResultList();
    }
    
    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }
    
    
    @Override
    @Transactional
    public void delete(Integer id) {
        
    	
//    	Get the student/
        Student theStudent = entityManager.find(Student.class, id);
        
        entityManager.remove(theStudent);

    }

    @Override
    @Transactional
    public int deleteAll() {
        int numOfRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numOfRowsDeleted;
    }



}
