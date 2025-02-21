package psu.edu.CRUD_demo.service;

import java.util.List;
import psu.edu.CRUD_demo.entity.Employee;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int theId);
    Employee save(Employee theEmployee);
    void deleteById(int theId);
    
    // Added new methods
    void updateBookId(int oldId, int newId);
    void deleteByBookId(int bookId);

}
