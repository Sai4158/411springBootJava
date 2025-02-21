package psu.edu.CRUD_demo.dao;

import java.util.List;
import psu.edu.CRUD_demo.entity.Employee;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int theId);
    Employee save(Employee theEmployee);
    void deleteById(int theId);

    // Added methods for updating and deleting Book ID
    void updateBookId(int oldId, int newId);
    void deleteByBookId(int bookId);
}
