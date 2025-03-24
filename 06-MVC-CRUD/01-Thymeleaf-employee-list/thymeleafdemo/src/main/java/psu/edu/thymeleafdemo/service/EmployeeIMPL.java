package psu.edu.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import psu.edu.thymeleafdemo.dao.EmployeeRepository;
import psu.edu.thymeleafdemo.entity.Employee;

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

        Employee theEmployee = null;

        if (result.isPresent()) {
            theEmployee = result.get();
        } 
        else {
            // we did not find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theEmployee;
    }

    @Override
    @Transactional
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        Employee tempEmployee = findById(theId);

        employeeRepository.deleteById(theId);
    }
}
