package psu.edu.thymeleafdemo.service;

import java.math.BigDecimal;
import java.util.List;

import psu.edu.thymeleafdemo.entity.Employee;

public interface EmployeeService {
    List<Employee> findAll();
    List<Employee> findBySalaryGreaterThan(BigDecimal salary);
    Employee findById(int theId);
    Employee save(Employee theEmployee);
    void deleteById(int theId);
}
