package psu.edu.quiz.service;

import java.util.List;

import psu.edu.quiz.entity.Employee;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int theId);
    Employee save(Employee theEmployee);
    void deleteById(int theId);
}
