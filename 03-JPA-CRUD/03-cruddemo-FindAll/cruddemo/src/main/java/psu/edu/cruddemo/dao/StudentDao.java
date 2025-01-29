package psu.edu.cruddemo.dao;

import java.util.List;
import psu.edu.cruddemo.entity.Student;

public interface StudentDao {
    void save(Student student);
    Student findById(Integer id);
    List<Student> findAll();
}
