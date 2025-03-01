package psu.edu.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import psu.edu.quiz.dao.EmployeeRepository;
import psu.edu.quiz.entity.Employee;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeIMPL implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeIMPL(EmployeeRepository theEmployeeRepository) {
        this.employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);

        if (result.isPresent()) {
            return result.get();
        } 
        else {
            // Employee not found
            throw new RuntimeException("Did not find employee id - " + theId);
        }
    }

    @Override
    @Transactional
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        // Check if employee exists before deletion
        findById(theId);
        employeeRepository.deleteById(theId);
    }
}
